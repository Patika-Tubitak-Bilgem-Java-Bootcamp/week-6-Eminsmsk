package com.example.rentacarportal.controller;

import com.example.rentacarportal.entity.Car;
import com.example.rentacarportal.entity.Company;
import com.example.rentacarportal.message.MessageResponse;
import com.example.rentacarportal.service.CarService;
import com.example.rentacarportal.service.CompanyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/add")
    public MessageResponse addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @GetMapping("/getById")
    public Car getCarById(@RequestParam Long id) {
        return carService.getCarById(id);
    }

    @GetMapping("/getByModel")
    public Car getCarByModel(@RequestParam String model){
        return carService.getCarByModel(model);
    }
}
