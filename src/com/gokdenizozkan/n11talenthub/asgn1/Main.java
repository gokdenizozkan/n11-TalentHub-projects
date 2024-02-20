package com.gokdenizozkan.n11talenthub.asgn1;

import com.gokdenizozkan.n11talenthub.asgn1.builder.AreaBuilder;
import com.gokdenizozkan.n11talenthub.asgn1.entity.Area;
import com.gokdenizozkan.n11talenthub.asgn1.misc.DwellingType;

public class Main {
    public static void main(String[] args) {
        Area area = AreaBuilder.buildTestArea();

        System.out.println("All test data:");
        area.getDwellings().forEach(System.out::println);

        System.out.println(
                "\n" +
                "All points required in Assignment #1\n" +
                "Point 1 - Total Price of All Houses:\n" + area.getDwellingService().calculateTotalPriceOf(DwellingType.HOUSE) + "\n\n" +
                "Point 2 - Total Price of All Villas:\n" + area.getDwellingService().calculateTotalPriceOf(DwellingType.VILLA) + "\n\n" +
                "Point 3 - Total Price of All Holiday Homes:\n" + area.getDwellingService().calculateTotalPriceOf(DwellingType.HOLIDAY_HOME) + "\n\n" +
                "Point 4 - Total Price of All Dwellings:\n" + area.getDwellingService().calculateTotalPriceOfAllDwellings() + "\n\n" +
                "Point 5 - Average Square Meters of All Houses:\n" + area.getDwellingService().calculateAverageSquareMetersOf(DwellingType.HOUSE) + "\n\n" +
                "Point 6 - Average Square Meters of All Villas:\n" + area.getDwellingService().calculateAverageSquareMetersOf(DwellingType.VILLA) + "\n\n" +
                "Point 7 - Average Square Meters of All Holiday Homes:\n" + area.getDwellingService().calculateAverageSquareMetersOf(DwellingType.HOLIDAY_HOME) + "\n\n" +
                "Point 8 - Average Square Meters of All Dwellings:\n" + area.getDwellingService().calculateAverageSquareMetersOfAllDwellings() + "\n\n" +
                "Point 9 - Dwellings with 2 Rooms and 1 Living Room:");
        area.getDwellingService().filterDwellingsByRoomAndLivingRoomCount(2, 1).forEach(System.out::println);
    }
}
