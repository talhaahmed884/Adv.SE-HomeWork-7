package com.cpp.homeWork7.vendor;

public enum VendingMachineStates {
    IDLE("Idle"),
    WAITING_FOR_MONEY("Waiting for Money"),
    DISPENSING_SNACK("Dispensing Snack"),
    DISPENSING_MONEY("Dispensing Money");

    private final String name;

    VendingMachineStates(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
