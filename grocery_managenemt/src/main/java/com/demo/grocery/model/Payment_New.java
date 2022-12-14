package com.demo.grocery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="payment_new")
public class Payment_New  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String username;
    private String userEmail;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private String paymentType;
    private int amount;
    private String orderDate;


    @OneToMany(orphanRemoval = false)
    private Set<AddToCartModel_New> addToCartModel_new;


    public Payment_New() {
    }

    public Payment_New(long id, String username, String userEmail, String phoneNumber, String address, String city, String state, String paymentType, int amount, String orderDate,  Set<AddToCartModel_New> addToCartModel_new) {
        this.id = id;
        this.username = username;
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.paymentType = paymentType;
        this.amount = amount;
        this.orderDate = orderDate;
        //this.isPurchased = isPurchased;
        this.addToCartModel_new = addToCartModel_new;
    }



    public Set<AddToCartModel_New> getAddToCartModel_new() {
        return addToCartModel_new;
    }

    public void setAddToCartModel_new(Set<AddToCartModel_New> addToCartModel_new) {
        this.addToCartModel_new = addToCartModel_new;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment_New{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", amount=" + amount +
                ", orderDate='" + orderDate + '\'' +
                ", addToCartModel_new=" + addToCartModel_new +
                '}';
    }
}
