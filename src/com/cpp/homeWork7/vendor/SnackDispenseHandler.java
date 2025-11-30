package com.cpp.homeWork7.vendor;

public abstract class SnackDispenseHandler {
    private SnackDispenseHandler nextHandler;

    void setNextHandler(SnackDispenseHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public boolean handleDispenseRequest(String itemName, double price) {
        if (canHandleItemType(itemName) && canHandleQuantity() && canHandlePrice(price)) {
            this.doHandleDispenseRequest();
            return true;
        } else if (this.nextHandler != null) {
            return this.nextHandler.handleDispenseRequest(itemName, price);
        } else {
            return false;
        }
    }

    protected abstract boolean canHandleQuantity();

    protected abstract boolean canHandleItemType(String itemName);

    protected abstract boolean canHandlePrice(double inputAmount);

    protected abstract void doHandleDispenseRequest();

    public Snack handleGetSnackRequest(String itemName) {
        if (canHandleItemType(itemName)) {
            return this.doHandleGetSnackRequest();
        } else if (this.nextHandler != null) {
            return this.nextHandler.handleGetSnackRequest(itemName);
        }
        return null;
    }

    protected abstract Snack doHandleGetSnackRequest();
}
