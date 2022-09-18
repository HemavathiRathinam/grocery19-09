package com.demo.grocery.controller;

import com.demo.grocery.model.FeedbackModel;
import com.demo.grocery.model.ProductModel;
import com.demo.grocery.service.FeedbackService;
import com.demo.grocery.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class FeedbackController {

        private final FeedbackService feedbackService;


        public FeedbackController(FeedbackService feedbackService) {
            this.feedbackService = feedbackService;
        }
        @GetMapping("/getFeedback")
        public ResponseEntity<List<FeedbackModel>> getFeedback(){
            List<FeedbackModel> feedbackModels=feedbackService.findAllFeedbackModel();
            //System.out.println(new ResponseEntity(productModels, HttpStatus.OK));
            return new ResponseEntity<>(feedbackModels, HttpStatus.OK);
        }
@GetMapping("/getFeedback/{feedId}")
private FeedbackModel getFeedbackById(@PathVariable("feedId") int feedId)
{
    return feedbackService.getFeedbackById(feedId);
}
        @PostMapping("/addFeedback")
        public ResponseEntity<FeedbackModel> addFeedback(@RequestBody FeedbackModel data){
            FeedbackModel newFeedbackModel=feedbackService.addFeedback(data);
            return new ResponseEntity(newFeedbackModel, HttpStatus.CREATED);
        }


        @PutMapping("/updateFeedback")
        public FeedbackModel updateFeedback(@RequestBody FeedbackModel add)
        {

            return feedbackService.updateFeedback(add);
        }
        @DeleteMapping("/deleteFeedback/{feedId}")
        public void deleteFeedback(@PathVariable("feedId") int feedId)
        {
            feedbackService.deleteFeedback(feedId);
        }


    }
