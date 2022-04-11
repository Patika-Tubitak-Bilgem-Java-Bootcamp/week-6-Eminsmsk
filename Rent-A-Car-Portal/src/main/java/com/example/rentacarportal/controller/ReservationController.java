package com.example.rentacarportal.controller;

import com.example.rentacarportal.entity.RentReservation;
import com.example.rentacarportal.message.MessageResponse;
import com.example.rentacarportal.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @GetMapping("/getById")
    public RentReservation getReservation(@RequestParam Long id) {
        return reservationService.getReservation(id);
    }

    @PostMapping
    public MessageResponse addReservation(@RequestBody RentReservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @GetMapping("/getByCompanyId")
    public List<RentReservation> getReservationsByCompany(@RequestParam Long id) {
        return reservationService.getReservationsByCompany(id);
    }

    @GetMapping("/getByUserId")
    public List<RentReservation> getReservationsByUser(@RequestParam Long id) {
        return reservationService.getReservationsByUser(id);
    }


}
