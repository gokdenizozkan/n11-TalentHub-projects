package com.gokdenizozkan.n11talenthub.asgn3.forecast;

import java.time.LocalDateTime;
import java.util.Map;

public record ForecastResponse(
        String country,
        String city,
        Map<LocalDateTime, String> forecasts,
        String temperatureUnit
) {
}
