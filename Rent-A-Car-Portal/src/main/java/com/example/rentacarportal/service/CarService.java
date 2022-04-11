package com.example.rentacarportal.service;

import com.example.rentacarportal.entity.Car;
import com.example.rentacarportal.message.MessageResponse;
import com.example.rentacarportal.message.MessageType;
import com.example.rentacarportal.repository.CarRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public MessageResponse addCar(Car car) {
        carRepository.save(car);
        return new MessageResponse(MessageType.SUCCESS,"Car is added to system");
    }

    public Car getCarById(Long id) {
        return carRepository.getById(id);
    }

    public Car getCarByModel(String model) {
        return carRepository.findByModel(model).orElseThrow(() -> new EntityNotFoundException("Car is not found by given model"));
    }
}
