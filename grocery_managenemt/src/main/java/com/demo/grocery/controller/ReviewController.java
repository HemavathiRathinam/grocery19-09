package com.demo.grocery.controller;


import com.demo.grocery.model.Review;
import com.demo.grocery.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/addReview")
    public ResponseEntity<Review> addReview(@RequestBody Review data){
        Review newReviewModel=reviewService.addReview(data);
        return new ResponseEntity(newReviewModel, HttpStatus.CREATED);
    }
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/getReview")
    public ResponseEntity<List<Review>> getReview(){
        List<Review> reviewModels= reviewService.findAllReviewModel();
        return new ResponseEntity<>(reviewModels, HttpStatus.OK);
    }
    @CrossOrigin("http://localhost:4200")
    @PutMapping("/updateReview")
    public Review updateReview(@RequestBody Review add)
    {

        return reviewService.updateReview(add);
    }
    @CrossOrigin("http://localhost:4200")
    @DeleteMapping("/deleteReview/{review_id}")
    public void deleteReview(@PathVariable("review_id") int review_id)
    {
        reviewService.deleteReview(review_id);
    }

}
