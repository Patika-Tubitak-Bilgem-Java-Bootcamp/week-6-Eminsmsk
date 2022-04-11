package com.example.rentacarportal.entity;

import com.example.rentacarportal.common.City;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Company extends BaseEntity {

    @NotNull
    @Column(unique=true)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private City city;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Car> cars;

}
