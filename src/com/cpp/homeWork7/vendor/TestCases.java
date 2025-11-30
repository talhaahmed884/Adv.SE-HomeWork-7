package com.cpp.homeWork7.vendor;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestCases {
    @Test
    public void Test_Case_Cheetos_Snack() {
        Snack cheetos = new Cheetos(5);
        Assertions.assertInstanceOf(Snack.class, cheetos);
        Assertions.assertInstanceOf(Cheetos.class, cheetos);
        Assertions.assertEquals(Snacks.CHEETOS, cheetos.getType());
        Assertions.assertEquals(5, cheetos.getQuantity());
        Assertions.assertEquals(1.55, cheetos.getPrice());
        Assertions.assertEquals("Cheetos", cheetos.getType().getName());
    }

    @Test
    public void Test_Case_Coke_Snack() {
        Snack coke = new Coke(5);
        Assertions.assertInstanceOf(Snack.class, coke);
        Assertions.assertInstanceOf(Coke.class, coke);
        Assertions.assertEquals(Snacks.COKE, coke.getType());
        Assertions.assertEquals(5, coke.getQuantity());
        Assertions.assertEquals(3.45, coke.getPrice());
        Assertions.assertEquals("Coke", coke.getType().getName());
    }

    @Test
    public void Test_Case_Doritos_Snack() {
        Snack doritos = new Doritos(5);
        Assertions.assertInstanceOf(Snack.class, doritos);
        Assertions.assertInstanceOf(Doritos.class, doritos);
        Assertions.assertEquals(Snacks.DORITOS, doritos.getType());
        Assertions.assertEquals(5, doritos.getQuantity());
        Assertions.assertEquals(9.25, doritos.getPrice());
        Assertions.assertEquals("Doritos", doritos.getType().getName());
    }

    @Test
    public void Test_Case_Kitkat_Snack() {
        Snack kitkat = new Kitkat(5);
        Assertions.assertInstanceOf(Snack.class, kitkat);
        Assertions.assertInstanceOf(Kitkat.class, kitkat);
        Assertions.assertEquals(Snacks.KITKAT, kitkat.getType());
        Assertions.assertEquals(5, kitkat.getQuantity());
        Assertions.assertEquals(0.5, kitkat.getPrice());
        Assertions.assertEquals("Kitkat", kitkat.getType().getName());
    }

    @Test
    public void Test_Case_Pepsi_Snack() {
        Snack pepsi = new Pepsi(5);
        Assertions.assertInstanceOf(Snack.class, pepsi);
        Assertions.assertInstanceOf(Pepsi.class, pepsi);
        Assertions.assertEquals(Snacks.PEPSI, pepsi.getType());
        Assertions.assertEquals(5, pepsi.getQuantity());
        Assertions.assertEquals(2.45, pepsi.getPrice());
        Assertions.assertEquals("Pepsi", pepsi.getType().getName());
    }

    @Test
    public void Test_Case_Snickers_Snack() {
        Snack snickers = new Snickers(5);
        Assertions.assertInstanceOf(Snack.class, snickers);
        Assertions.assertInstanceOf(Snickers.class, snickers);
        Assertions.assertEquals(Snacks.SNICKERS, snickers.getType());
        Assertions.assertEquals(5, snickers.getQuantity());
        Assertions.assertEquals(1.25, snickers.getPrice());
        Assertions.assertEquals("Snickers", snickers.getType().getName());
    }

    @Test
    public void Test_Case_Machine_Dispensing_Money_State_Basic() {
        StateOfVendingMachine state = new DispensingMoneyMachineState();
        Assertions.assertInstanceOf(StateOfVendingMachine.class, state);
        Assertions.assertInstanceOf(DispensingMoneyMachineState.class, state);
        Assertions.assertEquals(VendingMachineStates.DISPENSING_MONEY, state.state);
        Assertions.assertEquals("Dispensing Money", state.state.getName());
    }

    @Test
    public void Test_Case_Machine_Dispensing_Snack_State_Basic() {
        StateOfVendingMachine state = new DispensingSnackMachineState();
        Assertions.assertInstanceOf(StateOfVendingMachine.class, state);
        Assertions.assertInstanceOf(DispensingSnackMachineState.class, state);
        Assertions.assertEquals(VendingMachineStates.DISPENSING_SNACK, state.state);
        Assertions.assertEquals("Dispensing Snack", state.state.getName());
    }

    @Test
    public void Test_Case_Machine_Idle_State_Basic() {
        StateOfVendingMachine state = new IdleMachineState();
        Assertions.assertInstanceOf(StateOfVendingMachine.class, state);
        Assertions.assertInstanceOf(IdleMachineState.class, state);
        Assertions.assertEquals(VendingMachineStates.IDLE, state.state);
        Assertions.assertEquals("Idle", state.state.getName());
    }

    @Test
    public void Test_Case_Machine_Waiting_For_Money_State_Basic() {
        StateOfVendingMachine state = new WaitingForMoneyMachineState();
        Assertions.assertInstanceOf(StateOfVendingMachine.class, state);
        Assertions.assertInstanceOf(WaitingForMoneyMachineState.class, state);
        Assertions.assertEquals(VendingMachineStates.WAITING_FOR_MONEY, state.state);
        Assertions.assertEquals("Waiting for Money", state.state.getName());
    }

    @Test
    public void Test_Case_Snack_Dispense_Handler_Chain() {
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

        Assertions.assertInstanceOf(Coke.class, coke);
        Assertions.assertInstanceOf(Pepsi.class, pepsi);
        Assertions.assertInstanceOf(Cheetos.class, cheetos);
        Assertions.assertInstanceOf(Doritos.class, doritos);
        Assertions.assertInstanceOf(Kitkat.class, kitkat);
        Assertions.assertInstanceOf(Snack.class, snickers);

        Assertions.assertInstanceOf(Pepsi.class, coke.getNextHandler());
        Assertions.assertInstanceOf(Cheetos.class, pepsi.getNextHandler());
        Assertions.assertInstanceOf(Doritos.class, cheetos.getNextHandler());
        Assertions.assertInstanceOf(Kitkat.class, doritos.getNextHandler());
        Assertions.assertInstanceOf(Snickers.class, kitkat.getNextHandler());
        Assertions.assertNull(snickers.getNextHandler());

        Assertions.assertInstanceOf(Pepsi.class, coke.getNextHandler());
        Assertions.assertInstanceOf(Cheetos.class, coke.getNextHandler().getNextHandler());
        Assertions.assertInstanceOf(Doritos.class, coke.getNextHandler().getNextHandler().getNextHandler());
        Assertions.assertInstanceOf(Kitkat.class, coke.getNextHandler().getNextHandler().getNextHandler().getNextHandler());
        Assertions.assertInstanceOf(Snickers.class, coke.getNextHandler().getNextHandler().getNextHandler().getNextHandler().getNextHandler());
        Assertions.assertNull(coke.getNextHandler().getNextHandler().getNextHandler().getNextHandler().getNextHandler().getNextHandler());
        Assertions.assertThrowsExactly(NullPointerException.class, () -> {
            coke.getNextHandler().getNextHandler().
                    getNextHandler().getNextHandler().getNextHandler().getNextHandler().getNextHandler();
        });
    }

    @Test
    public void Test_Case_Vending_Machine_Basic() {
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

        Assertions.assertInstanceOf(VendingMachine.class, machine);
        Assertions.assertInstanceOf(IdleMachineState.class, machine.getState());
        Assertions.assertInstanceOf(Coke.class, machine.getSnackChain());
    }

    @Test
    public void Test_Case_Vending_Machine_Idle_State_1() {
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

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream oldStream = System.out;
        System.setOut(printStream);

//        making an illegal operation
        machine.insertMoney(3.5);
        Assertions.assertEquals("Illegal operation! Select an item to continue\n", outputStream.toString());
        outputStream.reset();

//        making an illegal operation
        machine.dispenseSnack();
        Assertions.assertEquals("Illegal operation! Select an item and insert money to continue\n", outputStream.toString());
        outputStream.reset();

//        making an illegal operation
        machine.dispenseMoney();
        Assertions.assertEquals("Illegal operation! Select an item and insert money to continue\n", outputStream.toString());
        outputStream.reset();

//        selecting unavailable product
        machine.selectSnack("Lays");
        Assertions.assertEquals("Snack Lays not available.\n", outputStream.toString());
        outputStream.reset();

        machine.selectSnack("Snickers");
        Assertions.assertInstanceOf(WaitingForMoneyMachineState.class, machine.getState());
        Assertions.assertEquals("User has selected item: Snickers\n", outputStream.toString());
        outputStream.reset();

        printStream.close();
        System.setOut(oldStream);
    }

    @Test
    public void Test_Case_Vending_Machine_Idle_State_2() {
        Snack coke = new Coke(0);
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

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream oldStream = System.out;
        System.setOut(printStream);

//        selecting unavailable product
        machine.selectSnack("Coke");
        Assertions.assertEquals("Snack Coke not available.\n", outputStream.toString());
        outputStream.reset();
        printStream.close();
        System.setOut(oldStream);
    }

    @Test
    public void Test_Case_Vending_Machine_Waiting_For_Money_State_1() {
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

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream oldStream = System.out;
        System.setOut(printStream);

        machine.selectSnack("Pepsi");
        Assertions.assertEquals("User has selected item: Pepsi\n", outputStream.toString());
        outputStream.reset();

//        making an illegal operation
        machine.selectSnack("Coke");
        Assertions.assertEquals("Illegal operation! Processing a transaction\n", outputStream.toString());
        outputStream.reset();

//        making an illegal operation
        machine.dispenseSnack();
        Assertions.assertEquals("Illegal operation! Processing a transaction\n", outputStream.toString());
        outputStream.reset();

//        making an illegal operation
        machine.dispenseMoney();
        Assertions.assertEquals("Illegal operation! Processing a transaction\n", outputStream.toString());
        outputStream.reset();

        machine.insertMoney(1);
        Assertions.assertEquals("""
                User has inserted amount: $1.00
                Current balance: $1.00
                Not enough funds yet. Insert at least: $1.45
                """, outputStream.toString());
        outputStream.reset();

        machine.insertMoney(2);
        Assertions.assertEquals("""
                User has inserted amount: $2.00
                Current balance: $3.00
                Enough funds inserted
                """, outputStream.toString());
        outputStream.reset();
        Assertions.assertInstanceOf(DispensingSnackMachineState.class, machine.getState());

        //        making an illegal operation
        machine.insertMoney(2);
        Assertions.assertEquals("Illegal operation! Processing a transaction\n", outputStream.toString());
        outputStream.reset();

        printStream.close();
        System.setOut(oldStream);
    }

    @Test
    public void Test_Case_Vending_Machine_Dispensing_Snack_State_1() {
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

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream oldStream = System.out;
        System.setOut(printStream);

        machine.selectSnack("Pepsi");
        Assertions.assertEquals("User has selected item: Pepsi\n", outputStream.toString());
        outputStream.reset();

        machine.insertMoney(1);
        Assertions.assertEquals("""
                User has inserted amount: $1.00
                Current balance: $1.00
                Not enough funds yet. Insert at least: $1.45
                """, outputStream.toString());
        outputStream.reset();

        machine.insertMoney(2);
        Assertions.assertEquals("""
                User has inserted amount: $2.00
                Current balance: $3.00
                Enough funds inserted
                """, outputStream.toString());
        outputStream.reset();

//        making an illegal operation
        machine.insertMoney(2);
        Assertions.assertEquals("Illegal operation! Processing a transaction\n", outputStream.toString());
        outputStream.reset();

//        making an illegal operation
        machine.selectSnack("Pepsi");
        Assertions.assertEquals("Illegal operation! Processing a transaction\n", outputStream.toString());
        outputStream.reset();

//        making an illegal operation
        machine.dispenseMoney();
        Assertions.assertEquals("Illegal operation! Processing a transaction\n", outputStream.toString());
        outputStream.reset();

        machine.dispenseSnack();
        Assertions.assertEquals("Dispensing item: Pepsi of price: $2.45\n", outputStream.toString());
        outputStream.reset();
        Assertions.assertInstanceOf(DispensingMoneyMachineState.class, machine.getState());

        printStream.close();
        System.setOut(oldStream);
    }

    @Test
    public void Test_Case_Vending_Machine_Dispensing_Money_State_1() {
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

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream oldStream = System.out;
        System.setOut(printStream);

        machine.selectSnack("Pepsi");
        Assertions.assertEquals("User has selected item: Pepsi\n", outputStream.toString());
        outputStream.reset();

        machine.insertMoney(3);
        Assertions.assertEquals("""
                User has inserted amount: $3.00
                Current balance: $3.00
                Enough funds inserted
                """, outputStream.toString());
        outputStream.reset();

        machine.dispenseSnack();
        Assertions.assertEquals("Dispensing item: Pepsi of price: $2.45\n", outputStream.toString());
        outputStream.reset();

//        making an illegal operation
        machine.selectSnack("Pepsi");
        Assertions.assertEquals("Illegal operation! Processing a transaction\n", outputStream.toString());
        outputStream.reset();

//        making an illegal operation
        machine.insertMoney(4);
        Assertions.assertEquals("Illegal operation! Processing a transaction\n", outputStream.toString());
        outputStream.reset();

//        making an illegal operation
        machine.dispenseSnack();
        Assertions.assertEquals("Illegal operation! Processing a transaction\n", outputStream.toString());
        outputStream.reset();

        machine.dispenseMoney();
        Assertions.assertEquals("Dispensing balance: $0.55\n", outputStream.toString());
        outputStream.reset();
        Assertions.assertInstanceOf(IdleMachineState.class, machine.getState());

        printStream.close();
        System.setOut(oldStream);
    }
}
