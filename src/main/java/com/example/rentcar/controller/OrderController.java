package com.example.rentcar.controller;

import com.example.rentcar.model.Order;
import com.example.rentcar.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/findByCarId/{id}")//根据车的id查找预约单
    public List<Order> findByCarId(@PathVariable int id){
        return orderService.findByCarId(id);
    }

    @GetMapping("/findByUserId/{id}")//根据用户的id查找所有预约单
    public List<Order> findByUserId(@PathVariable int id){
        return orderService.findByUserId(id);
    }

    @GetMapping("/findByOrderring/{id}")//查找用户的正在预约的预约单
    public List<Order> findByUserIdAndStartTimeAfter(@PathVariable int id){
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        return orderService.findByUserIdAndStartTimeAfter(id,ts);
    }

    @GetMapping("/findByEnd/{id}")//查找用户的已经完成的预约单
    public List<Order> findByUserIdAndEndTimeBefore(@PathVariable int id){
        Date now = new Date();
        Timestamp ts = new Timestamp(now.getTime());
        return orderService.findByUserIdAndEndTimeBefore(id,ts);
    }

    @PostMapping("/order")//预约
    public String order(@RequestBody Order order){
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode node = objectMapper.createObjectNode();
        if(orderService.order(order)){
            node.put("message","true");
            return node.toString();
        } else {
            node.put("message","false");
            return node.toString();
        }
    }

    @DeleteMapping("/cancelOrder/{id}")
    public String cancelOrder(@PathVariable int id){
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode node = objectMapper.createObjectNode();
        if (orderService.cancelOrder(id)){
            node.put("message","true");
            return node.toString();
        } else {
            node.put("message","false");
            return node.toString();
        }
    }

}
