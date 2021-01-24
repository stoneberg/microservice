package com.stone.payment.service.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stone.payment.service.ms.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
