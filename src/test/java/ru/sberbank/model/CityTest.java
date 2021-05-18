package ru.sberbank.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityTest {

    @Test
    public void whenTestGetMethods() {
        City newCity = new City(1, "Nsk", "Novosib", "Novosibirsk", 1623512, 1923);
        assertEquals(newCity.getDistrict(), "Novosibirsk");
        assertEquals(newCity.getName(), "Nsk");
        assertEquals(newCity.getPopulation(), 1623512);
    }

    @Test
    public void whenTestEguals() {
        City newCity = new City(1, "Nsk", "Novosib", "Novosibirsk", 1623512, 1923);
        City newCity2 = new City(1, "Nsk", "Novosib", "Novosibirsk", 1623512, 1923);
        assertTrue(newCity.equals(newCity2));
    }

    @Test
    public void whenTestToString() {
        City newCity = new City(1, "Nsk", "Novosib", "Novosibirsk", 1623512, 1923);
        assertEquals(newCity.toString(), "City{id=1, name='Nsk', region='Novosib', district='Novosibirsk', population=1623512, foundation=1923}");
    }
}