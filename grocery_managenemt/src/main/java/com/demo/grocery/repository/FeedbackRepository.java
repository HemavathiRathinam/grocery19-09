package com.demo.grocery.repository;

import com.demo.grocery.model.FeedbackModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeedbackRepository extends JpaRepository<FeedbackModel, Integer> {
//    Optional<ProductModel> findProductModelByName(String prodName);
}
