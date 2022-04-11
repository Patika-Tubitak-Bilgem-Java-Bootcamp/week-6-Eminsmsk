package com.example.rentacarportal.service;

import com.example.rentacarportal.entity.RentReservation;
import com.example.rentacarportal.message.MessageResponse;
import com.example.rentacarportal.message.MessageType;
import com.example.rentacarportal.repository.RentReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final RentReservationRepository reservationRepository;

    public ReservationService(RentReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    public RentReservation getReservation(Long id) {
       return reservationRepository.getById(id);
    }


    public MessageResponse addReservation(RentReservation reservation) {
        reservationRepository.save(reservation);
        return new MessageResponse(MessageType.SUCCESS,"Reservation is made!");
    }

    public List<RentReservation> getReservationsByCompany(Long id) {
        return reservationRepository.findAllByCompanyId(id);
    }

    public List<RentReservation> getReservationsByUser(Long id) {
        return reservationRepository.findAllByUserId(id);
    }
}
