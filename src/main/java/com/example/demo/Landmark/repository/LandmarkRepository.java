package com.example.demo.Landmark.repository;

import com.example.demo.Landmark.entity.Landmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandmarkRepository extends JpaRepository<Landmark,Integer> {

}
