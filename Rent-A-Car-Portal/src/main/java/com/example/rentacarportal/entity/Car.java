package com.example.rentacarportal.entity;

import com.example.rentacarportal.common.CarType;
import com.example.rentacarportal.repository.RentReservationRepository;
import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Car extends BaseEntity {

    @NotNull
    @Enumerated(EnumType.STRING)
    private CarType carType;

    @NotNull
    private String brand;

    @NotNull
    @Column(unique=true)
    private String model;

    @NotNull
    private Long price;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<DailyPriceByDateRange> priceRangesByDateRange;

    public boolean isCarAvailable(RentReservationRepository repository, LocalDate startDate, LocalDate endDate){
        return repository.findAllByStartDateBetweenAndCar(startDate, endDate, this).isEmpty();
    }


}
