package com.example.rentcar.service;

import com.example.rentcar.model.Order;

import java.sql.Timestamp;
import java.util.List;

public interface OrderService {
    List<Order>  findByCarId(int id);

    List<Order> findByUserId(int id);

    List<Order> findByUserIdAndStartTimeAfter(int id,Timestamp now);

    List<Order> findByUserIdAndEndTimeBefore(int id,Timestamp now);

    boolean order(Order order);

    boolean cancelOrder(int id);
}
