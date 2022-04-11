package com.example.rentacarportal.controller;

import com.example.rentacarportal.entity.Company;
import com.example.rentacarportal.message.MessageResponse;
import com.example.rentacarportal.service.CompanyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @PostMapping("/add")
    public MessageResponse addCompany(@RequestBody Company company) {
        return companyService.addCompany(company);
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

    @GetMapping("/{name}")
    public Company getCompanyByName(@PathVariable String name){
        return companyService.getCompanyByName(name);
    }


}
