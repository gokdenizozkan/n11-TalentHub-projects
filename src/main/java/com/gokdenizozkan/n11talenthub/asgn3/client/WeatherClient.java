package com.gokdenizozkan.n11talenthub.asgn3.client;

import com.gokdenizozkan.n11talenthub.asgn3.forecast.ForecastResponseRaw;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weather", url = "https://api.open-meteo.com/v1")
public interface WeatherClient {

    @RequestMapping(path = "/forecast", method = RequestMethod.GET)
    ForecastResponseRaw forecastFor(@RequestParam("latitude") Double latitude, @RequestParam("longitude") Double longitude,
                                    @RequestParam("hourly") String hourlyVariables, @RequestParam("forecast_days") Integer forecastDays);
}
