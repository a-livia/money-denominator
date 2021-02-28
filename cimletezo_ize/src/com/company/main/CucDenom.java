package com.company.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CucDenom implements Denominator {
    private List<Integer> denominationsCUC = Arrays.asList(100, 50, 25, 20, 10, 5, 3, 1);
    @Override
    public HashMap<Integer, Integer> denomMethod(int sum) {
        if (sum <= 0) {
            throw new IllegalArgumentException();
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer denomination : denominationsCUC) {
            if (sum / denomination > 0) {
                hashMap.put(denomination, sum / denomination);
                sum = sum % denomination;
            }
        }
        return hashMap;
    }
}
