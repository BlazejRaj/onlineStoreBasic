package com.projekt.projektkoncowy.repository;

import com.projekt.projektkoncowy.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
