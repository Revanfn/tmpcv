package model;

import enums.TempUnit;

public class Temperature {
    private final double amount;
    private final TempUnit unit;

    public Temperature(double amount, TempUnit tempUnit) {
        this.amount = amount;
        this.unit = tempUnit;
    }

    public Temperature(double amount) {
        this.amount = amount;
        this.unit = TempUnit.CELSIUS;
    }

    public Temperature(Temperature toCopy) {
        this.amount = toCopy.getAmount();
        this.unit = toCopy.getUnit();
    }

    public double getAmount() {
        return amount;
    }

    public TempUnit getUnit() {
        return unit;
    }
}
