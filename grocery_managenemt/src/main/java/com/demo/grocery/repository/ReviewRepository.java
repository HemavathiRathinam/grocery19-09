package com.demo.grocery.repository;


import com.demo.grocery.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository <Review,Integer> {
}
