package com.gokdenizozkan.n11talenthub.asgn1.misc;

import com.gokdenizozkan.n11talenthub.asgn1.entity.HolidayHome;
import com.gokdenizozkan.n11talenthub.asgn1.entity.House;
import com.gokdenizozkan.n11talenthub.asgn1.entity.Villa;

import java.lang.reflect.Constructor;

public enum DwellingType {
    HOUSE(House.class), HOLIDAY_HOME(HolidayHome.class), VILLA(Villa.class);

    private final Class<?> dwellingClass;

    DwellingType(Class<?> dwellingClass) {
        this.dwellingClass = dwellingClass;
    }

    public Class<?> getDwellingClass() {
        return dwellingClass;
    }

    public Constructor<?> getNoArgsConstructor() {
        try {
            return dwellingClass.getDeclaredConstructor();
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }
}
