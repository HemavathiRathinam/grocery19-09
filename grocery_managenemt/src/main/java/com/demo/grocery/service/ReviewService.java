package com.demo.grocery.service;


import com.demo.grocery.model.Review;
import com.demo.grocery.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepo;

    public Review addReview(Review data)
    {
        return reviewRepo.save(data);
    }
    public List<Review> findAllReviewModel()
    {
        return reviewRepo.findAll();
    }
    public Review updateReview(Review m)
    {
        int review_id=m.getReview_id();
        Review add=reviewRepo.findById(review_id).get();
        add.setFeedback(m.getFeedback());
        add.setName(m.getName());
        add.setRating(m.getRating());
        return reviewRepo.save(add);
    }
    public void deleteReview(int review_id)

    {
        reviewRepo.deleteById(review_id);
    }
}
