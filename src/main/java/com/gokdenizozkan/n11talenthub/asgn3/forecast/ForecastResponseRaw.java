package com.gokdenizozkan.n11talenthub.asgn3.forecast;

import java.util.Map;

public record ForecastResponseRaw(
        Double latitude,
        Double longitude,
        String generationtime_ms,
        Long utc_offset_seconds,
        String timezone,
        String timezone_abbreviation,
        String elevation,
        Map<String, String> hourly_units,
        Map<String, String[]> hourly
) {
}
