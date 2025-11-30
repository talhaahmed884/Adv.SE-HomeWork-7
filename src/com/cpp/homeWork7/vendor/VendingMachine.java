package com.cpp.homeWork7.vendor;

public class VendingMachine {
    private StateOfVendingMachine machineState;
    private Snack snackChain;

    public VendingMachine() {
        this.machineState = new IdleMachineState();
        snackChain = null;
    }

    public VendingMachine(Snack snacks) {
        this.machineState = new IdleMachineState();
        this.snackChain = snacks;
    }

    public StateOfVendingMachine getState() {
        return machineState;
    }

    public void setState(StateOfVendingMachine state) {
        this.machineState = state;
    }

    public Snack getSnackChain() {
        return snackChain;
    }

    public void setSnackChain(Snack snacks) {
        this.snackChain = snacks;
    }

    public void selectSnack(String snackName) {
        this.machineState.selectSnack(this, snackName);
    }

    public void insertMoney(double amount) {
        this.machineState.insertMoney(this, amount);
    }

    public void dispenseSnack() {
        this.machineState.dispenseSnack(this);
    }

    public void dispenseMoney() {
        this.machineState.dispenseMoney(this);
    }
}
