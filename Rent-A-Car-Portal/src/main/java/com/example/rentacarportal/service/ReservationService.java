package com.example.rentacarportal.service;

import com.example.rentacarportal.entity.Car;
import com.example.rentacarportal.entity.RentReservation;
import com.example.rentacarportal.message.MessageResponse;
import com.example.rentacarportal.message.MessageType;
import com.example.rentacarportal.repository.CarRepository;
import com.example.rentacarportal.repository.RentReservationRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ReservationService {

    private final RentReservationRepository reservationRepository;
    private final CarRepository carRepository;

    public ReservationService(RentReservationRepository reservationRepository, CarRepository carRepository) {
        this.reservationRepository = reservationRepository;
        this.carRepository = carRepository;
    }

    public RentReservation getReservation(Long id) {
        return reservationRepository.getById(id);
    }


    public MessageResponse addReservation(RentReservation reservation) {
        Car car = carRepository.findById(reservation.getCar().getId()).orElseThrow(() -> new EntityNotFoundException("Car is not found"));
        if (car.isCarAvailable(reservationRepository, reservation.getStartDate(), reservation.getEndDate())) {
            reservationRepository.save(reservation);
            return new MessageResponse(MessageType.SUCCESS, "Reservation is made!");
        } else {
            return new MessageResponse(MessageType.ERROR, "The car is not available for this date range!");

        }

    }

    public List<RentReservation> getReservationsByCompany(Long id) {
        return reservationRepository.findAllByCompanyId(id);
    }

    public List<RentReservation> getReservationsByUser(Long id) {
        return reservationRepository.findAllByUserId(id);
    }
}
