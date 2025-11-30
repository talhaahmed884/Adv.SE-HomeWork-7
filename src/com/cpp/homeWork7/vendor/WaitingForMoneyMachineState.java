package com.cpp.homeWork7.vendor;

public class WaitingForMoneyMachineState extends StateOfVendingMachine {
    public WaitingForMoneyMachineState() {
        super(VendingMachineStates.WAITING_FOR_MONEY);
    }

    public WaitingForMoneyMachineState(String name, double inputAmount) {
        super(VendingMachineStates.WAITING_FOR_MONEY, name, inputAmount);
    }

    @Override
    public void selectSnack(VendingMachine machine, String itemName) {
        System.out.println("Illegal operation! Processing a transaction");
    }

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.printf("User has inserted amount: $%.2f\n", amount);
        this.inputAmount += amount;
        System.out.printf("Current balance: $%.2f\n", this.inputAmount);

        Snack snack = machine.getSnackChain().handleGetSnackRequest(this.selectedItemName);
        double snackPrice = snack.getPrice();
        if (snackPrice > this.inputAmount) {
            System.out.printf("Not enough funds yet. Insert at least: $%.2f\n", (snackPrice - this.inputAmount));
            return;
        }

        System.out.println("Enough funds inserted");
        machine.setState(new DispensingSnackMachineState(this.selectedItemName, this.inputAmount));
    }

    @Override
    public void dispenseSnack(VendingMachine machine) {
        System.out.println("Illegal operation! Processing a transaction");
    }

    @Override
    public void dispenseMoney(VendingMachine machine) {
        System.out.println("Illegal operation! Processing a transaction");
    }
}
