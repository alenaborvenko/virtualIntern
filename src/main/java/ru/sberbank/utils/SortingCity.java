package ru.sberbank.utils;

import ru.sberbank.model.City;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Утилитный класс для сортировки и группировки городов
 */
public class SortingCity {

    /**
     * Метод для сортировки списка городов по имени
     * @param cities - список городов
     */
    public static void sortByName(List<City> cities) {
        cities.sort((s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()));
    }

    /**
     * Метод для сортировки сначала по федеральному округу, затем по имени
     * @param cities - список городов
     */
    public static void sortByDistrictThenName(List<City> cities) {
        cities.sort(Comparator.comparing(City::getDistrict)
                .thenComparing(City::getName));
    }

    /**
     * Метод для получения максимальной численности среди списков городов и индекс в массиве этого города
     * @param cities - список городов
     * @return - массив, в котором первый элемент - это численность, а второй - индекс
     */
    public static long[] getMaxPopulationAndIndex(List<City> cities) {
        long[] rsl = new long[2];
        rsl[0] = 0;
        rsl[1] = -1;
        City[] listToArray = new City[cities.size()];
        cities.toArray(listToArray);
        for (int i = 0; i < listToArray.length; i++) {
            if (rsl[0] < listToArray[i].getPopulation()) {
                rsl[0] = listToArray[i].getPopulation();
                rsl[1] = i;
            }
        }
        return rsl;
    }

    /**
     * Метод, для отображения регионов и численность городов в этом регионе
     * @param cities - список городов
     * @return - HashMap<Регион, Количество городов в этом регионе>
     */
    public static Map<String, Long> groupByRegin(List<City> cities) {
        return cities.stream()
                .collect(Collectors.groupingBy(City::getDistrict, Collectors.counting()));
    }
}
