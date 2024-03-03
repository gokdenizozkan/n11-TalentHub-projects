package com.gokdenizozkan.n11talenthub.asgn3.config;

import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;

@Component
public class Locator {
    private final File countriesAndCities;

    public Locator() {
        this.countriesAndCities = new File("src/main/resources/worldcities.csv");
    }

    public Double[] locateByCountryAndCity(String country, String city) {
        try {
            return Files.lines(countriesAndCities.toPath())
                    .filter(line -> line.contains(country) && line.contains(city))
                    .map(line -> line.split(","))
                    .map(arr -> new Double[]{
                            Double.parseDouble(arr[2].replaceAll("\"", "")),
                            Double.parseDouble(arr[3].replaceAll("\"", ""))
                    })
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
