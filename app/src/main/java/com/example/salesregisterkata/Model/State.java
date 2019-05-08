package com.example.salesregisterkata.Model;

public enum State {
    UT(6.85),
    NV(8.00),
    TX(6.25),
    AL(4.00),
    CA(8.25);

    private double taxRate;

    State(double taxRate) {
        this.taxRate = taxRate;
    }

    State getStateFromCode(String stateCode) {
        switch (stateCode.toUpperCase()) {
            case "UT":
                return UT;
            case "NV":
                return NV;
            case "TX":
                return TX;
            case "AL":
                return AL;
            case "CA":
                return CA;
            default:
                throw new UnsupportedOperationException("This state code is either invalid or not supported");
        }
    }

    public double getTaxRate() {
        return taxRate;
    }
}
