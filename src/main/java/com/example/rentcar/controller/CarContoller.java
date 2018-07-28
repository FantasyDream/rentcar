package com.example.rentcar.controller;


import com.example.rentcar.model.Car;
import com.example.rentcar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("car")
public class CarContoller {

    @Autowired
    CarService carService;

    @GetMapping("/findAll")
    public List<Car> findAll(){
        return carService.findAll();
    }

    @GetMapping("/getOne/{id}")
    public Car getOne(@PathVariable int id){
        return carService.getOne(id);
    }

}
