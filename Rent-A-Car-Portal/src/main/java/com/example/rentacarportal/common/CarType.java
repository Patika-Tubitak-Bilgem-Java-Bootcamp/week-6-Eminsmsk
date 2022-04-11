package com.example.rentacarportal.common;

public enum CarType {
    BINEK("Binek"),
    ARAZI("Arazi"),
    TICARI("Ticari"),
    TIR("Uzun araç(TIR)");

    CarType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
