package com.cpp.homeWork7.vendor;

public class IdleMachineState extends StateOfVendingMachine {
    public IdleMachineState() {
        super(VendingMachineStates.IDLE);
    }

    public IdleMachineState(String name, double inputAmount) {
        super(VendingMachineStates.IDLE, name, inputAmount);
    }

    @Override
    public void selectSnack(VendingMachine machine, String itemName) {
        Snack snack = machine.getSnackChain().handleGetSnackRequest(itemName);
        if (snack == null) {
            System.out.println("Snack " + itemName + " not available.");
            machine.setState(new IdleMachineState());
            return;
        }

        int snackQuantity = snack.getQuantity();
        if (snackQuantity == 0) {
            System.out.println("Snack " + itemName + " not available.");
            machine.setState(new IdleMachineState());
            return;
        }

        System.out.println("User has selected item: " + itemName);
        this.selectedItemName = itemName;
        machine.setState(new WaitingForMoneyMachineState(this.selectedItemName, this.inputAmount));
    }

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.println("Illegal operation! Select an item to continue");
        machine.setState(new IdleMachineState());
    }

    @Override
    public void dispenseSnack(VendingMachine machine) {
        System.out.println("Illegal operation! Select an item and insert money to continue");
        machine.setState(new IdleMachineState());
    }

    @Override
    public void dispenseMoney(VendingMachine machine) {
        System.out.println("Illegal operation! Select an item and insert money to continue");
        machine.setState(new IdleMachineState());
    }
}
