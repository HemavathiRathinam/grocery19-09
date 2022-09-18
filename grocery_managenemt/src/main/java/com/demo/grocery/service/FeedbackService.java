package com.demo.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.grocery.model.FeedbackModel;
import com.demo.grocery.model.ProductModel;
import com.demo.grocery.repository.FeedbackRepository;
import com.demo.grocery.repository.ProductRepository;
@Service
public class FeedbackService {
    private static FeedbackRepository feedbackRepository=null;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository=feedbackRepository;
    }

    public static FeedbackModel addFeedback(FeedbackModel data){
        return feedbackRepository.save(data);

    }
    public static List<FeedbackModel> findAllFeedbackModel(){

        return feedbackRepository.findAll();
    }

public FeedbackModel getFeedbackById(int id)
{
    return feedbackRepository.findById(id).get();
}
    public FeedbackModel updateFeedback(FeedbackModel feed)
    {
        int feedId=feed.getFeedId();
        FeedbackModel add=feedbackRepository.findById(feedId).get();
        add.setFeedName(feed.getFeedName());
        add.setFeedEmailid(feed.getFeedEmailid());
        add.setFeedText(feed.getFeedText());
        return feedbackRepository.save(add);
    }

    public void deleteFeedback(int feedId)
    {

        feedbackRepository.deleteById(feedId);
    }
}
