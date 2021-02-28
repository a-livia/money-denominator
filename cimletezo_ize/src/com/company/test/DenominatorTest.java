package com.company.test;

import com.company.main.DenominatorFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DenominatorTest {
    HashMap<Integer, Integer> hash = new HashMap<>();

    public HashMap<Integer, Integer> convertList(List<Integer> list) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size() - 1; i = i + 2) {
            map.put(list.get(i + 1), list.get(i));
        }
        return map;
    }

    @ParameterizedTest
    @MethodSource("denominators")
    void denomMethodValidDataTest(int sum, List<Integer> list, String type) {
        var result = new DenominatorFactory().getDenominator(type).denomMethod(sum);
        hash = convertList(list);
        assertEquals(result, hash);
    }

    private static Stream<Arguments> denominators() {
        return Stream.of(
                Arguments.of(15410, Arrays.asList(1, 10000, 1, 5000, 2, 200, 1, 10), "HUF"),
                Arguments.of(20000, Arrays.asList(1, 20000), "HUF"),
                Arguments.of(14, Arrays.asList(1, 10, 1, 3, 1, 1), "CUC"),
                Arguments.of(225, Arrays.asList(2, 100, 1, 25), "CUC")
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-210, 12, 0})
    void denomMethodInvalidDataTest(int sum) {
        assertThrows(
                IllegalArgumentException.class,
                () ->         new DenominatorFactory().getDenominator("HUF").denomMethod(sum)
        );
    }

    @ParameterizedTest
    @MethodSource("types")
    void denomTypeInvalidTest(String type){
        assertEquals(new DenominatorFactory().getDenominator(type),null);
    }

    private static Stream<Arguments> types() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("FORINT")
        );
    }
}
