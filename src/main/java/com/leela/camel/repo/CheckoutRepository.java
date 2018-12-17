package com.leela.camel.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.leela.camel.model.OrderInfo;

public interface CheckoutRepository extends 
JpaRepository<OrderInfo, Long>{
OrderInfo findByid(Long id) ;


}
