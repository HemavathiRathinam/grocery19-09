package com.demo.grocery.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="cartdetails_new")
public class AddToCartModel_New  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(nullable = false,updatable = false)
    private int cartId;

    private String username;
    private String prodName;
    private int prodPrice;
    private int prodquantity;
    private String prodWeight;
    private String prodImg;
    private int subtotal;
    private int id;
    //private int purchased;

//    @ManyToOne
//    private Payment_New payment_new;

//    public Payment_New getPayment_new() {
//        return payment_new;
//    }
//
//    public void setPayment_new(Payment_New payment_new) {
//        this.payment_new = payment_new;
//    }


//    public int getPurchased() {
//        return purchased;
//    }
//
//    public void setPurchased(int purchased) {
//        this.purchased = purchased;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AddToCartModel_New(int cartId, String username, String prodName, int prodPrice, int prodquantity, String prodWeight, String prodImg, int subtotal, int id,int purchased) {
        this.cartId = cartId;
        this.username = username;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.prodquantity = prodquantity;
        this.prodWeight = prodWeight;
        this.prodImg = prodImg;
        this.subtotal = subtotal;
        this.id = id;
        //this.purchased = purchased;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
    }

    public int getProdquantity() {
        return prodquantity;
    }

    public void setProdquantity(int prodquantity) {
        this.prodquantity = prodquantity;
    }

    public String getProdWeight() {
        return prodWeight;
    }

    public void setProdWeight(String prodWeight) {
        this.prodWeight = prodWeight;
    }

    public String getProdImg() {
        return prodImg;
    }

    public void setProdImg(String prodImg) {
        this.prodImg = prodImg;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }



    public AddToCartModel_New(){

    }

    @Override
    public String toString() {
        return "AddToCartModel_New{" +
                "cartId=" + cartId +
                ", username='" + username + '\'' +
                ", prodName='" + prodName + '\'' +
                ", prodPrice=" + prodPrice +
                ", prodquantity=" + prodquantity +
                ", prodWeight='" + prodWeight + '\'' +
                ", prodImg='" + prodImg + '\'' +
                ", subtotal=" + subtotal +
                ", id=" + id +
                //", payment_new=" + payment_new +
                '}';
    }
}
