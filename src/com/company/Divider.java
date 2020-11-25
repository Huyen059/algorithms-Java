package com.company;

public class Divider implements Calculator {
    @Override
    public int calculate(int i, int i1) {
        if (i1 == 0) {
            System.out.println("Divided by zero");
            return i1;
        }
        return i / i1;
    }
}
