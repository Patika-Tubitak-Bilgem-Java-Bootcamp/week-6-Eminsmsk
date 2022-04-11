package com.example.rentacarportal.repository;

import com.example.rentacarportal.entity.DailyPriceByDateRange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyPriceByDateRangeRepository extends JpaRepository<DailyPriceByDateRange, Long> {


}
