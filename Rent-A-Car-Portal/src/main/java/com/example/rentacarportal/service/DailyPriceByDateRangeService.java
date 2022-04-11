package com.example.rentacarportal.service;

import com.example.rentacarportal.entity.DailyPriceByDateRange;
import com.example.rentacarportal.message.MessageResponse;
import com.example.rentacarportal.message.MessageType;
import com.example.rentacarportal.repository.DailyPriceByDateRangeRepository;
import org.springframework.stereotype.Service;

@Service
public class DailyPriceByDateRangeService {

    private final DailyPriceByDateRangeRepository dailyPriceRepository;

    public DailyPriceByDateRangeService(DailyPriceByDateRangeRepository dailyPriceRepository) {
        this.dailyPriceRepository = dailyPriceRepository;
    }


    public MessageResponse addDailyPrice(DailyPriceByDateRange dailyPrice) {
        dailyPriceRepository.save(dailyPrice);
        return new MessageResponse(MessageType.SUCCESS, "Daily price added according to start and end date");
    }

    public DailyPriceByDateRange getDailyPrice(Long id) {
        return dailyPriceRepository.getById(id);
    }

}
