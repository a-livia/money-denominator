package com.company.test;

import com.company.main.Cimletezo;
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

public class CimletezoTest {

    Cimletezo cimletezo = new Cimletezo();
    HashMap<Integer, Integer> hash = new HashMap<>();

    public HashMap<Integer, Integer> convertList(List<Integer> list) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size() - 1; i = i + 2) {
            map.put(list.get(i + 1), list.get(i));
        }
        return map;
    }

    @ParameterizedTest
    @MethodSource("cimletek")
    void cimletMethodTestValid(int osszeg, List<Integer> list) {
        var result = cimletezo.cimletezoMethod(osszeg);
        hash = convertList(list);
        assertEquals(result, hash);
    }

    private static Stream<Arguments> cimletek() {
        return Stream.of(
                Arguments.of(15410, Arrays.asList(1, 10000, 1, 5000, 2, 200, 1, 10)),
                Arguments.of(20000, Arrays.asList(1, 20000))
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-210, 12, 0})
    void cimletMethodTestInvalid(int osszeg) {
        assertThrows(
                IllegalArgumentException.class,
                () -> cimletezo.cimletezoMethod(osszeg)
        );
    }
}
