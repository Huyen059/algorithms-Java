package com.company;

public class Main {

    public static void main(String[] args) {
        CountSquare countSquare = new CountSquare();
        System.out.println(countSquare.countNumberOfSquares(countSquare.getOneSquare()));
        System.out.println(countSquare.countNumberOfSquares(countSquare.getDoubleSquare()));
        System.out.println(countSquare.countNumberOfSquares(countSquare.getTripleSquare()));
        System.out.println(countSquare.countNumberOfSquares(countSquare.getFourSquares()));
        System.out.println(countSquare.countNumberOfSquares(countSquare.getComplexSquareInSquare()));
        System.out.println(countSquare.countNumberOfSquares(countSquare.getAbsurdlyBigSquare()));
    }

}
