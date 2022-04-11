package com.example.rentacarportal.controller;

import com.example.rentacarportal.entity.Company;
import com.example.rentacarportal.entity.DailyPriceByDateRange;
import com.example.rentacarportal.message.MessageResponse;
import com.example.rentacarportal.message.MessageType;
import com.example.rentacarportal.service.DailyPriceByDateRangeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dailyPrice")
public class DailyPriceByDateRangeController {

    private final DailyPriceByDateRangeService dailyPriceService;

    public DailyPriceByDateRangeController(DailyPriceByDateRangeService dailyPriceService) {
        this.dailyPriceService = dailyPriceService;
    }

    @PostMapping
    public MessageResponse addDailyPrice(@RequestBody DailyPriceByDateRange dailyPrice) {
        return dailyPriceService.addDailyPrice(dailyPrice);
    }

    @GetMapping("/getById")
    public DailyPriceByDateRange getCompanyById(@RequestParam Long id) {
        return dailyPriceService.getDailyPrice(id);
    }



}
