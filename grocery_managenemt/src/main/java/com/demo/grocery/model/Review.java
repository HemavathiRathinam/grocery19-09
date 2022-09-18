package com.demo.grocery.model;

import javax.persistence.*;

@Entity
@Table(name="review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int review_id;
    @Column(name="Name")
    private String name;
    @Column(name="Feedback")
    private String feedback;
    @Column(name="Rating")
    private int rating;
    public Review()
    {
        super();
    }
    public Review(String name, String feedback, int rating) {
        super();
        this.name = name;
        this.feedback = feedback;
        this.rating = rating;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
