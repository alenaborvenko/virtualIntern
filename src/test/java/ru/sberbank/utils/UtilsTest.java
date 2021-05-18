package ru.sberbank.utils;

import org.junit.After;
import org.junit.Test;
import ru.sberbank.model.City;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;

public class UtilsTest {

    PrintStream old = System.out;

    @Test
    public void whenGetListFromFile() throws IOException {
        List<City> actual = Utils.getListCityFromFile("./src/test/java/ru/sberbank/city.txt");
        assertEquals(actual.get(9),
                new City(10, "Аксай", "Ростовская область", "Южный", 41984, 1570));
        assertEquals(actual.get(59),
                new City(60, "Балашиха", "Московская область", "Центральный", 215353, 1830));
    }

    @Test
    public void whenTestPrintOnConsole() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        City first = new City(10, "Аксай", "Ростовская область", "Южный", 41984, 1570);
        City second = new City(60, "Балашиха", "Московская область", "Центральный", 215353, 1830);
        System.setOut(new PrintStream(out));
        Utils.printOnConsole(List.of(
                first,
                second
        ));
        assertEquals(out.toString(), first.toString() + System.lineSeparator() + second.toString() + System.lineSeparator());
    }

    @Test (expected = IOException.class)
    public void whenNoFile() throws IOException {
        Utils.getListCityFromFile("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIllegalFile() throws IOException {
        Utils.getListCityFromFile("./src/test/java/ru/sberbank/cityNoCorrect.txt");
    }

    @After
    public void afterTests() {
        System.setOut(old);
    }
}