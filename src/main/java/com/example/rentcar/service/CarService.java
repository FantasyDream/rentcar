package com.example.rentcar.service;

import com.example.rentcar.model.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();

    Car getOne(int id);
}
