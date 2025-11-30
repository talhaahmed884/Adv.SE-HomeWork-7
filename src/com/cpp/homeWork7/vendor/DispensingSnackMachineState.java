package com.cpp.homeWork7.vendor;

public class DispensingSnackMachineState extends StateOfVendingMachine {
    public DispensingSnackMachineState() {
        super(VendingMachineStates.DISPENSING_SNACK);
    }

    public DispensingSnackMachineState(String name, double money) {
        super(VendingMachineStates.DISPENSING_MONEY, name, money);
    }

    @Override
    public void selectSnack(VendingMachine machine, String itemName) {
        System.out.println("Illegal operation! Processing a transaction");
    }

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.println("Illegal operation! Processing a transaction");
    }

    @Override
    public void dispenseSnack(VendingMachine machine) {
        Snack snack = machine.getSnackChain().handleGetSnackRequest(this.selectedItemName);
        double snackPrice = snack.getPrice();
        if (snackPrice > this.inputAmount) {
            System.out.println("Current balance: $" + this.inputAmount);
            System.out.printf("Not enough funds yet. Insert at least: $%.2f\n", (snackPrice - this.inputAmount));
            return;
        }

        machine.getSnackChain().handleDispenseRequest(this.selectedItemName, this.inputAmount);
        this.inputAmount -= snackPrice;
        machine.setState(new DispensingMoneyMachineState(this.selectedItemName, this.inputAmount));
    }

    @Override
    public void dispenseMoney(VendingMachine machine) {
        System.out.println("Illegal operation! Processing a transaction");
    }
}
