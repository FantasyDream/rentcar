package com.example.rentcar.service.impl;

import com.example.rentcar.dao.CarDao;
import com.example.rentcar.model.Car;
import com.example.rentcar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarDao carDao;

    public List<Car> findAll(){
        return carDao.findAll();
    }

    public Car getOne(int id){ return carDao.getOne(id); }

}
