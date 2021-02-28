package com.company.main;

public class Main {

    public static void main(String[] args) {
        DenominatorFactory denominatorFactory = new DenominatorFactory();
        System.out.println(denominatorFactory.getDenominator("HUF").denomMethod(25));
        System.out.println(denominatorFactory.getDenominator("CUC").denomMethod(25));
    }
}
