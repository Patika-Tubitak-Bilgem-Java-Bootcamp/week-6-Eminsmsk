package com.example.rentacarportal.repository;

import com.example.rentacarportal.entity.Car;
import com.example.rentacarportal.entity.RentReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RentReservationRepository extends JpaRepository<RentReservation, Long> {

    List<RentReservation> findAllByUserId(Long userId);
    List<RentReservation> findAllByCompanyId(Long companyId);

    List<RentReservation> findAllByStartDateBetweenAndCar(LocalDate startDate, LocalDate endDate, Car car);


}
