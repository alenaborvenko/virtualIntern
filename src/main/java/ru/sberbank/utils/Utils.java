package ru.sberbank.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sberbank.main.Main;
import ru.sberbank.model.City;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Утилитный класс для работы с файлами (считывание из файла в список объектов модели)
 * вывода в консоль
 */
public class Utils {
    /**
     * Метод, для считывания данных из файлов и добавления в спиков объектов модели
     * @param path - строка с путем файла
     * @return - ArrayList с объектами модели
     * @throws IOException - exception при неудачной работе с файлами
     */
    public static List<City> getListCityFromFile(String path) throws IOException {
        List<City> rsl = new ArrayList<>();
        try (Scanner buffRead = new Scanner(new FileReader(path))) {
            String line;
            while (buffRead.hasNext()) {
                line = buffRead.nextLine();
                String[] parseLine = line.split(";");
               if (parseLine.length != 6) {
                   throw new IllegalArgumentException("Wrong line " + line);
               }
                City newCity = new City(
                        Integer.parseInt(parseLine[0]),
                        parseLine[1],
                        parseLine[2],
                        parseLine[3],
                        Long.parseLong(parseLine[4]),
                        Integer.parseInt(parseLine[5]));
                rsl.add(newCity);
            }
        }
        return rsl;
    }

    /**
     * Метод ля вывода коллекции в консоль
     * @param objects - список объектов
     */
    public static void printOnConsole(List<City> objects) {
        objects.forEach(System.out::println);
    }

}
