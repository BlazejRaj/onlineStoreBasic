package com.projekt.projektkoncowy.repository;

import com.projekt.projektkoncowy.entity.Order;
import com.projekt.projektkoncowy.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

}
