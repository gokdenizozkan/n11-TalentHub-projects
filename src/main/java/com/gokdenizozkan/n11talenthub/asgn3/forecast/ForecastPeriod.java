package com.gokdenizozkan.n11talenthub.asgn3.forecast;

public enum ForecastPeriod {
    WEEK(7), FORTNIGHT(14), MAX(16), MIN(1);

    private final int days;

    ForecastPeriod(int days) {
        this.days = days;
    }

    public int get() {
        return days;
    }
}
