package com.rohanbari.loopdecision;

public class IntegerNumber {
    private int number;

    public IntegerNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void increment() {
        number++;
    }

    public void decrement() {
        number--;
    }
}
