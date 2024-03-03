package com.gokdenizozkan.n11talenthub.asgn3.forecast;

import com.gokdenizozkan.n11talenthub.asgn3.client.WeatherClient;
import com.gokdenizozkan.n11talenthub.asgn3.config.Locator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

@Service
public class ForecastService {
    private final WeatherClient weatherClient;
    private final Locator locator;

    public ForecastService(WeatherClient weatherClient, Locator locator) {
        this.weatherClient = weatherClient;
        this.locator = locator;
    }

    public ForecastResponse forecastFor(String country, String city, ForecastPeriod period) {
        String timeKey = "time";
        String temperatureKey = "temperature_2m";

        Double[] coordinates = locator.locateByCountryAndCity(country, city);

        ForecastResponseRaw responseRaw;
        responseRaw = weatherClient.forecastFor(coordinates[0], coordinates[1], temperatureKey, period.get());

        String[] times = responseRaw.hourly().get(timeKey);
        String[] temperatures = responseRaw.hourly().get(temperatureKey);

        Map<LocalDateTime, String> forecasts = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            forecasts.put(
                    LocalDateTime.parse(times[i]),
                    temperatures[i]);
        }

        return new ForecastResponse(
                country,
                city,
                forecasts,
                responseRaw.hourly_units().get(temperatureKey));
    }
}
