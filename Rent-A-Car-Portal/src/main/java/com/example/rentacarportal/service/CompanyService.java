package com.example.rentacarportal.service;

import com.example.rentacarportal.entity.Company;
import com.example.rentacarportal.message.MessageResponse;
import com.example.rentacarportal.message.MessageType;
import com.example.rentacarportal.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public MessageResponse addCompany(Company company) {
        companyRepository.save(company);
        return new MessageResponse(MessageType.SUCCESS, "Company is added to system");
    }

    public Company getCompanyById(Long id) {
        return companyRepository.getById(id);
    }

    public Company getCompanyByName(String name) {
        return companyRepository.findByName(name).orElseThrow(()->new EntityNotFoundException("Not found"));
    }
}
