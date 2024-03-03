# Forecast API

This API provides weather forecast information for a specific country and city for a specified period.

## API Endpoints

### GET /api/v1/forecast/{country}/{city}?name={period}

Fetches the forecast for a specific country and city for a specified period.

Example: `GET /api/v1/forecast/Turkey/Istanbul?period=WEEK`

#### Parameters

- `country` (path parameter): The country for which the forecast is to be fetched.
- `city` (path parameter): The city for which the forecast is to be fetched.
- `period` (request parameter): The period for which the forecast is to be fetched. Can be one of the values from the ForecastPeriod enum (WEEK, FORTNIGHT, MAX, MIN).

#### Response

Returns a ForecastResponse object containing the forecast information.