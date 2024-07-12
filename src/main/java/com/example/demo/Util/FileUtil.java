package com.example.demo.Util;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/*
 * 전달받은 파일스트림을 특정 폴더에 저장하고 파일이름을 반환한다
 * 만약 파일스트림이 없다면 메소드를 바로 종료한다
 * */
@Component
public class FileUtil {

	//이미지 파일을 저장할 경로
//	@Value("${filepath}")
//	String filepath;

	@Autowired
	AmazonS3 amazonS3;

	String bucketName = "attibus-bucket";

//	public String fileUpload(MultipartFile multipartFile) {
//		Path copyOfLocation = null;
//
//		if(multipartFile.isEmpty()) { //파일스트림이 없으면 메소드를 종료한다
//			return null;
//		}
//		try {
//			copyOfLocation = Paths
//					.get(filepath + File.separator + StringUtils.cleanPath(multipartFile.getOriginalFilename())); //파일 전체 경로
//
//			Files.copy(multipartFile.getInputStream(), copyOfLocation, StandardCopyOption.REPLACE_EXISTING); //파일을 폴더에 저장
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		//파일이름을 반환한다
//		return multipartFile.getOriginalFilename();
//	}

	public String fileUpload(MultipartFile image) {

		if (image.isEmpty()) { // 이미지가 없으면 메소드 종료
			return null;
		}

		String url = uploadImageToS3(image);

		return url;
	}

	private String uploadImageToS3(MultipartFile image) {

		String originalFilename = image.getOriginalFilename(); // 원본 파일 명
		String extention = originalFilename.substring(originalFilename.lastIndexOf(".")); // 확장자 명
		String s3FileName = UUID.randomUUID().toString().substring(0, 10) + originalFilename; // 변경된 파일 명

		InputStream is;
		try {
			is = image.getInputStream();
			byte[] bytes = IOUtils.toByteArray(is); // image를 byte[]로 변환

			ObjectMetadata metadata = new ObjectMetadata(); // metadata 생성
			metadata.setContentType("image/" + extention.replace(".", "")); //.png -> png
			metadata.setContentLength(bytes.length);

			// S3에 요청할 때 사용할 byteInputStream 생성
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

			// S3로 putObject 할 때 사용할 요청 객체
			// 생성자 : bucket 이름, 파일 명, byteInputStream, metadata
			PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, s3FileName, byteArrayInputStream, metadata)
					.withCannedAcl(CannedAccessControlList.PublicRead);

			// 실제로 S3에 이미지 데이터를 넣는 부분이다.
			amazonS3.putObject(putObjectRequest); // put image to S3

		} catch (IOException e) {
			e.printStackTrace();
		}

		return amazonS3.getUrl(bucketName, s3FileName).toString();
	}

}
