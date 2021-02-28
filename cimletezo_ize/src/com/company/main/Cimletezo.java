package com.company.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Cimletezo {
    //5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000, 20000 :)

    private final List<Integer> cimletek = Arrays.asList(20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5);

    public HashMap<Integer, Integer> cimletezoMethod(int osszeg) throws IllegalArgumentException {
        if (osszeg <= 0 || osszeg % 5 != 0) {
            throw new IllegalArgumentException();
        }
        HashMap<Integer, Integer> bontas = new HashMap<>();
        for (Integer cimlet : cimletek) {
            if (osszeg / cimlet > 0) {
                bontas.put(cimlet, osszeg / cimlet);
                osszeg = osszeg % cimlet;
            }
        }
        return bontas;
    }
}
