package com.demo.grocery.controller;

import com.demo.grocery.model.Payment;
import com.demo.grocery.model.Payment_New;
import com.demo.grocery.service.PaymentService;
import com.demo.grocery.service.PaymentService_New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/payments_new")
public class PaymentController_New {
    @Autowired
    private final PaymentService_New paymentService;

    public PaymentController_New(PaymentService_New paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Payment_New>> getAllUser(){
        List<Payment_New> user=paymentService.findAllUser();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/find/{id}")
    public ResponseEntity<Payment_New> getUserById(@PathVariable("id") Long id){
        Payment_New user=paymentService.findPaymentById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Payment_New> updateUsers(@PathVariable("id") Long id,@RequestBody Payment_New user){
        Payment_New update = paymentService.updateUser(user);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Payment_New> addNewUser(@RequestBody Payment_New user){
        Payment_New newUser=paymentService.addUser(user);
        System.out.println(newUser);
        return new ResponseEntity<>(newUser,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        paymentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
