package com.example.calc;

public class Model {
    private double res = 0;

    public String getResult() {
        return String.format("%.0f", res);
    }

    public void addDigit(int d) {
        res = res * 10 + d;
    }
}
