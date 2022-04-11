package com.example.rentacarportal.repository;

import com.example.rentacarportal.common.City;
import com.example.rentacarportal.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByName(String name);
    List<Company> findByCity(City city);
}
