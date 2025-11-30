package com.cpp.homeWork7.vendor;

public class DispensingMoneyMachineState extends StateOfVendingMachine {
    public DispensingMoneyMachineState() {
        super(VendingMachineStates.DISPENSING_MONEY);
    }

    public DispensingMoneyMachineState(String name, double money) {
        super(VendingMachineStates.DISPENSING_MONEY, name, money);
    }

    @Override
    public void selectSnack(VendingMachine machine, String itemName) {
        System.out.println("Illegal operation! Processing a transaction.");
    }

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.println("Illegal operation! Processing a transaction.");
    }

    @Override
    public void dispenseSnack(VendingMachine machine) {
        System.out.println("Illegal operation! Processing a transaction");
    }

    @Override
    public void dispenseMoney(VendingMachine machine) {
        System.out.printf("Dispensing balance: $%.2f\n", this.inputAmount);
        machine.setState(new IdleMachineState());
    }
}
