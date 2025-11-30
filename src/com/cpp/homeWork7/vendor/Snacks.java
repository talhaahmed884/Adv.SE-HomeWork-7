package com.cpp.homeWork7.vendor;

public enum Snacks {
    COKE("Coke", 3.45),
    PEPSI("Pepsi", 2.45),
    CHEETOS("Cheetos", 1.55),
    DORITOS("Doritos", 9.25),
    KITKAT("Kitkat", 0.5),
    SNICKERS("Snickers", 1.25);

    private final String name;
    private final double price;

    Snacks(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
