package com.example.rentcar.dao;

import com.example.rentcar.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface OrderDao extends JpaRepository<Order,Integer> {
    List<Order>  findByCar_id(int id);

    List<Order> findByUserId(int id);

    List<Order> findByUserIdAndStartTimeAfter(int id,Timestamp now);

    List<Order> findByUserIdAndEndTimeBefore(int id,Timestamp now);
}
