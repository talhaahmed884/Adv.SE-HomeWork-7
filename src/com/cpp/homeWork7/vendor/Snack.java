package com.cpp.homeWork7.vendor;

public abstract class Snack extends SnackDispenseHandler {
    private final Snacks type;
    private int quantity;

    public Snack(Snacks type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public Snacks getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return type.getPrice();
    }

    @Override
    public String toString() {
        return "Snack: " + this.type.getName() + ", Price: $" + this.type.getPrice();
    }

    @Override
    protected boolean canHandleQuantity() {
        return this.quantity > 0;
    }

    @Override
    protected boolean canHandleItemType(String itemName) {
        return this.type.getName().equalsIgnoreCase(itemName);
    }

    @Override
    protected boolean canHandlePrice(double inputAmount) {
        return this.type.getPrice() <= inputAmount;
    }

    @Override
    protected void doHandleDispenseRequest() {
        System.out.println("Dispensing item: " + this.type.getName() + " of price: $" + this.type.getPrice());
        this.quantity--;
    }

    @Override
    protected Snack doHandleGetSnackRequest() {
        return this;
    }
}
