package com.company.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HufDenom implements Denominator {
    private List<Integer> denominationsHUF = Arrays.asList(20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5);
    @Override
    public HashMap<Integer, Integer> denomMethod(int sum) {
        if (sum <= 0 || sum % 5 != 0) {
            throw new IllegalArgumentException();
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (Integer denomination : denominationsHUF) {
            if (sum / denomination > 0) {
                hashMap.put(denomination, sum / denomination);
                sum = sum % denomination;
            }
        }
        return hashMap;
    }
}
