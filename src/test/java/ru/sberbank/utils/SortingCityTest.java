package ru.sberbank.utils;

import org.junit.Test;
import ru.sberbank.model.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SortingCityTest {
    private List<City> test = new ArrayList<>(List.of(
            new City(1, "Новосибирск", "Новосибирская область", "Сибирский", 1620162L, 1893),
            new City(2, "Москва", "Московская область", "Центральный", 12655050L, 1147),
            new City(3, "Санкт-Петербург", "Северо-Западный", "Северо-Западный", 5388769L, 1703)

    ));

    @Test
    public void whenSortByName() {
        SortingCity.sortByName(test);
        assertEquals(test, new ArrayList<>(List.of(
                new City(2, "Москва", "Московская область", "Центральный", 12655050L, 1147),
                new City(1, "Новосибирск", "Новосибирская область", "Сибирский", 1620162L, 1893),
                new City(3, "Санкт-Петербург", "Северо-Западный", "Северо-Западный", 5388769L, 1703)
        )));
    }

    @Test
    public void whenSortByDistinct() {
        test.add(new City(4, "Питер", "Северо-Западный", "Северо-Западный", 5388769, 1703));
        SortingCity.sortByDistrictThenName(test);
        assertEquals(new ArrayList<>(List.of(
                new City(4, "Питер", "Северо-Западный", "Северо-Западный", 5388769, 1703),
                new City(3, "Санкт-Петербург", "Северо-Западный", "Северо-Западный", 5388769L, 1703),
                new City(1, "Новосибирск", "Новосибирская область", "Сибирский", 1620162L, 1893),
                new City(2, "Москва", "Московская область", "Центральный", 12655050L, 1147)
        )), test);

    }

    @Test
    public void whenGetMaxPopulation() {
        long[] max = SortingCity.getMaxPopulationAndIndex(test);
        long[] expected = {12655050L, 1};
        assertArrayEquals(expected, max);
    }

    @Test
    public void whenGroupingBy() {
        Map<String, Long> mapExpected = new HashMap<>(Map.of(
                "Сибирский", 1L,
                "Центральный", 1L,
                "Северо-Западный", 2L
        ));
        Map<String, Long> mapActual = SortingCity.groupByRegin(test);

    }

}