package com.demo.grocery.service;

import com.demo.grocery.exception.UserNotFoundException;
import com.demo.grocery.model.Payment;

import com.demo.grocery.model.Payment_New;
import com.demo.grocery.repository.PaymentRepo_New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PaymentService_New {
    private final PaymentRepo_New paymentRepo;

    @Autowired
    public PaymentService_New(PaymentRepo_New paymentRepo) {
        this.paymentRepo = paymentRepo;
    }


    public Payment_New addUser(Payment_New user) {
        return paymentRepo.save(user);
    }

    public List<Payment_New> findAllUser() {return paymentRepo.findAll(); }

    public Payment_New updateUser(Payment_New user){ return paymentRepo.save(user); }
    public Payment_New findPaymentById(Long id){
        return paymentRepo.findPaymentById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id "+id+" was not found"));
    }
    public void deleteById(Long id){ paymentRepo.deleteById(id);}
}
