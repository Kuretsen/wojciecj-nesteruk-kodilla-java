package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World {
    private final List<Continent> listOfContinents = new ArrayList<>();

    public void addContinent(Continent continent) {
        listOfContinents.add(continent);
    }
    public BigDecimal getPeopleQuantity() {
        BigDecimal peopleQuantityOnTheWorld = listOfContinents.stream()
                .flatMap(continent -> continent.getListOfCountries().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, country) -> sum.add(country));
        return peopleQuantityOnTheWorld;
    }
}
