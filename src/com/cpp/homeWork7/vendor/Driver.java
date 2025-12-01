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
        Snack snickers = new Snickers(5);
        kitkat.setNextHandler(snickers);

        VendingMachine machine = new VendingMachine();
        machine.setSnackChain(coke);

        System.out.println("A new operation");
        machine.selectSnack("Snickers");
        machine.dispenseSnack();
        machine.dispenseMoney();
        machine.insertMoney(1);
        machine.dispenseSnack();
        machine.dispenseMoney();
        machine.insertMoney(1);
        machine.dispenseSnack();
        machine.dispenseMoney();
        System.out.println();

        System.out.println("A new operation");
        machine.selectSnack("Snackers");
        System.out.println();

        System.out.println("A new operation");
        machine.selectSnack("Cheetos");
        machine.insertMoney(1.5);
        machine.dispenseSnack();
        machine.dispenseMoney();
        machine.insertMoney(1.5);
        machine.dispenseSnack();
        machine.dispenseMoney();
        System.out.println();

        System.out.println("A new operation");
        machine.selectSnack("Snickers");
        machine.insertMoney(4);
        machine.dispenseSnack();
        machine.dispenseMoney();
        System.out.println();

        System.out.println("A new operation");
        machine.selectSnack("Snickers");
        machine.insertMoney(3);
        machine.dispenseSnack();
        machine.dispenseMoney();
        System.out.println();

        System.out.println("A new operation");
        machine.selectSnack("Doritos");
        machine.insertMoney(3);
        machine.dispenseSnack();
        machine.dispenseMoney();
        machine.insertMoney(10);
        machine.dispenseSnack();
        machine.dispenseMoney();
        System.out.println();

        System.out.println("A new operation");
        machine.selectSnack("Doritos");
        machine.insertMoney(3);
        machine.dispenseSnack();
        machine.dispenseMoney();
        machine.insertMoney(7);
        machine.dispenseSnack();
        machine.dispenseMoney();
        System.out.println();

        System.out.println("A new operation");
        machine.selectSnack("Doritos");
        machine.insertMoney(7);
        machine.dispenseSnack();
        machine.dispenseMoney();
        machine.insertMoney(2.25);
        machine.dispenseSnack();
        machine.dispenseMoney();
        System.out.println();

        System.out.println("A new operation");
        machine.selectSnack("Snickers");
        machine.insertMoney(20);
        machine.dispenseSnack();
        machine.dispenseMoney();
        System.out.println();

        System.out.println("A new operation");
        machine.selectSnack("Doritos");
        machine.insertMoney(10);
        machine.dispenseSnack();
        machine.dispenseMoney();
        System.out.println();

        System.out.println("A new operation");
        machine.selectSnack("Snickers");
        machine.insertMoney(1);
        machine.dispenseSnack();
        machine.dispenseMoney();
        machine.selectSnack("Doritos");
        machine.dispenseSnack();
        machine.dispenseMoney();
        machine.selectSnack("Coke");
        machine.insertMoney(3);
        machine.dispenseSnack();
        machine.dispenseMoney();
        System.out.println();

        System.out.println("A new operation");
        machine.selectSnack("Pepsi");
        machine.dispenseSnack();
        machine.dispenseMoney();
        machine.insertMoney(1);
        machine.dispenseSnack();
        machine.dispenseMoney();
        machine.insertMoney(1);
        machine.dispenseSnack();
        machine.dispenseMoney();
        machine.selectSnack("Kitkat");
        machine.insertMoney(1);
        machine.dispenseSnack();
        machine.selectSnack("Kitkat");
        machine.dispenseMoney();
        System.out.println();

        System.out.println("A new operation");
        machine.selectSnack("Snickers");
    }
}
