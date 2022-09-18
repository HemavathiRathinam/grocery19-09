package com.demo.grocery.repository;

import com.demo.grocery.model.Payment;
import com.demo.grocery.model.Payment_New;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepo_New extends JpaRepository<Payment_New, Long> {
        void deleteById(Long pay_id);

        Optional<Payment_New> findPaymentById(Long pay_id);

        }


