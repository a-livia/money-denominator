package com.company.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Cimletezo {
    public static List<Integer> cimletekHUF = Arrays.asList(20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5);
    public static List<Integer> cimletekCUC = Arrays.asList(100, 50, 25, 20, 10, 5, 3, 1);

    public static HashMap<Integer, Integer> cimletezoMethod(int sum, String cimletTipus) throws IllegalArgumentException {
        switch (cimletTipus) {
            case "HUF":
                if (sum <= 0 || sum % 5 != 0) {
                    throw new IllegalArgumentException();
                }
                return cimletezoSeged(sum,cimletekHUF);

            case "CUC":
                return cimletezoSeged(sum,cimletekCUC);
        }
        return null;
    }

    public static HashMap<Integer, Integer> cimletezoSeged(int sum, List<Integer> cimletTipus){
        HashMap<Integer, Integer> bontas = new HashMap<>();
        for (Integer cimlet : cimletTipus) {
            if (sum / cimlet > 0) {
                bontas.put(cimlet, sum / cimlet);
                sum = sum % cimlet;
            }
        }
        return bontas;
    }
}
