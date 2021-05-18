package ru.sberbank.model;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Модель, описывающая город
 *
 */
public class City {

    private int id;
    private String name;
    private String region;
    private String district;
    private long population;
    private int foundation;

    public City(int id, String name, String region, String district, long population, int foundation) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    /**
     * Геттер для поля имя класса City
     * @return - имя города
     */
    public String getName() {
        return name;
    }

    /**
     * Геттер для поля федеральный округ для класса City
     * @return - назавание федерального округа для этого города
     */
    public String getDistrict() {
        return district;
    }
    /**
     * Геттер для популяции класса City
     * @return - количество жителей в этом городе
     */
    public long getPopulation() {
        return population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id && population == city.population && foundation == city.foundation && Objects.equals(name, city.name) && Objects.equals(region, city.region) && Objects.equals(district, city.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, region, district, population, foundation);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", City.class.getSimpleName() + "{", "}")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("region='" + region + "'")
                .add("district='" + district + "'")
                .add("population=" + population)
                .add("foundation=" + foundation)
                .toString();
    }
}
