package com.demo.grocery.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="feedbacks")
public class FeedbackModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private int feedId;
    private String feedName;
    private String feedEmailid;
    private String feedText;

    public FeedbackModel(int feedId, String feedName, String feedEmailid, String feedText) {
        this.feedId = feedId;
        this.feedName = feedName;        
        this.feedEmailid = feedEmailid;
        this.feedText = feedText;
    }

    public FeedbackModel() {
    }

    public int getFeedId() {
        return feedId;
    }

    public void setFeedId(int feedId) {
        this.feedId = feedId;
    }

    public String getFeedName() {
        return feedName;
    }

    public void setFeedName(String feedName) {
        this.feedName = feedName;
    }
    
    public String getFeedEmailid() {
        return feedEmailid;
    }

    public void setFeedEmailid(String feedEmailid) {
        this.feedEmailid = feedEmailid;
    }

    public String getFeedText() {
        return feedText;
    }

    public void setFeedText(String feedText) {
        this.feedText = feedText;
    }

    @Override
    public String toString() {
        return "FeedbackModel{" +
                "feedId=" + feedId +
                ", feedName='" + feedName + '\'' +                
                ", feedEmailid='" + feedEmailid + '\'' +
                ", feedText='" + feedText + '\'' +
                '}';
    }
}
