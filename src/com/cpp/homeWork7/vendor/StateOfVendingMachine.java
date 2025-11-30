package com.cpp.homeWork7.vendor;

public abstract class StateOfVendingMachine {
    protected final VendingMachineStates state;
    protected String selectedItemName;
    protected double inputAmount;

    protected StateOfVendingMachine(VendingMachineStates state, String selectedItemName, double inputAmount) {
        this.state = state;
        this.selectedItemName = selectedItemName;
        this.inputAmount = inputAmount;
    }

    protected StateOfVendingMachine(VendingMachineStates state) {
        this.state = state;
    }

    public abstract void selectSnack(VendingMachine machine, String itemName);

    public abstract void insertMoney(VendingMachine machine, double amount);

    public abstract void dispenseSnack(VendingMachine machine);

    public abstract void dispenseMoney(VendingMachine machine);
}
