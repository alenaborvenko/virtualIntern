package ru.sberbank.main;

import ru.sberbank.model.City;
import ru.sberbank.utils.SortingCity;
import ru.sberbank.utils.Utils;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *Класс с точкой входа в программу (реализация с консольным интерфейсом)
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String pathFile = "./src/main/resources/city.txt";
        List<City> cities = Utils.getListCityFromFile(pathFile);
        Scanner in = new Scanner(System.in);
        boolean getAction = true;
        while (getAction) {
            menu();
            String action = in.nextLine();
            switch (action) {
                case "1":
                    Utils.printOnConsole(cities);
                    break;
                case "2":
                    SortingCity.sortByName(cities);
                    break;
                case "3":
                    SortingCity.sortByDistrictThenName(cities);
                    break;
                case "4":
                    long[] max = SortingCity.getMaxPopulationAndIndex(cities);
                    System.out.printf("[%d]=%d",max[1], max[0]);
                    break;
                case "5":
                    Map<String, Long> map = SortingCity.groupByRegin(cities);
                    for (String key: map.keySet()) {
                        System.out.println(key + " - " + map.get(key));
                    }
                    break;
                case "6":
                    getAction = false;
                    break;
                default:
                    System.out.println("Введите число от 1 до 6");

            }
        }
    }

    public static void menu() {
        System.out.println("Введите команду");
        System.out.println("1. Вывести на консоль список городов");
        System.out.println("2. Сортировать по наименованию");
        System.out.println("3. Сортировать по сначала по федеральному округу, затем по имени");
        System.out.println("4. Получить максимальную численность и индекс");
        System.out.println("5. Отображения регионов и численность городов в этом регионе");
        System.out.println("6.Выход");
    }
}
