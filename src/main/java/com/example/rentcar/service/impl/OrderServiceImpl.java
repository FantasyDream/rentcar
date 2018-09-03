package com.example.rentcar.service.impl;

import com.example.rentcar.dao.CarDao;
import com.example.rentcar.dao.OrderDao;
import com.example.rentcar.model.Car;
import com.example.rentcar.model.Order;
import com.example.rentcar.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    CarDao carDao;

    @Override
    public List<Order> findByCarId(int id) {
        return orderDao.findByCar_id(id);
    }

    @Override
    public List<Order> findByUserId(int id) {
        return orderDao.findByUserId(id);
    }

    @Override
    public List<Order> findByUserIdAndStartTimeAfter(int id,Timestamp now){
        return orderDao.findByUserIdAndStartTimeAfter(id,now);
    }

    @Override
    public List<Order> findByUserIdAndEndTimeBefore(int id,Timestamp now){
        return orderDao.findByUserIdAndEndTimeBefore(id,now);
    }

    @Override
    public boolean order(Order order) {
        int carId=order.getCar_id();
        Car car = carDao.getOne(carId);
        List<Order> orders = orderDao.findByCar_id(carId);
        System.out.println(order.getStartTime());
        System.out.println(order.getEndTime());
        if(car.getStartTime().after(order.getStartTime()) || car.getEndTime().before(order.getEndTime())){
            return false;
        }
        for(Order one: orders){
            if((one.getStartTime().before(order.getEndTime()) && one.getEndTime().after(order.getEndTime()))||(one.getEndTime().after(order.getStartTime())&&one.getStartTime().before(order.getStartTime()))){
                System.out.println("order");
                return false;
            }
        }
        order.setCar(car);
        orderDao.save(order);
        return true;
    }

    @Override
    public boolean cancelOrder(int id) {
        orderDao.deleteById(id);
        try{
            orderDao.getOne(id).getStartTime();
            return false;
        } catch (Exception e){
            return true;
        }
    }
}
