package com.gokdenizozkan.n11talenthub.asgn3.forecast;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/forecast")
public class ForecastController {
    private final ForecastService forecastService;

    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    @GetMapping("/{country}/{city}")
    public ForecastResponse forecastFor(@PathVariable String country, @PathVariable String city, @RequestParam ForecastPeriod period) {
        return forecastService.forecastFor(country, city, period);
    }
}
