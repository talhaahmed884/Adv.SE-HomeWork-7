package com.cpp.homeWork7.vendor;

public class Driver {
    public static void main(String[] args) {
        Snack coke = new Coke(5);
        Snack pepsi = new Pepsi(6);
        coke.setNextHandler(pepsi);
        Snack cheetos = new Cheetos(6);
        pepsi.setNextHandler(cheetos);
        Snack doritos = new Doritos(3);
        cheetos.setNextHandler(doritos);
        Snack kitkat = new Kitkat(2);
        doritos.setNextHandler(kitkat);
        Snack snickers = new Snickers(7);
        kitkat.setNextHandler(snickers);

        VendingMachine machine = new VendingMachine();
        machine.setSnackChain(coke);

        machine.selectSnack("Snickers");
        machine.dispenseSnack();
        machine.dispenseMoney();
        machine.insertMoney(1);
        machine.dispenseSnack();
        machine.dispenseMoney();
        machine.insertMoney(1);
        machine.dispenseSnack();
        machine.dispenseMoney();
    }
}
