package com.gokdenizozkan.n11talenthub.asgn1.builder;

import com.gokdenizozkan.n11talenthub.asgn1.blueprint.Dwelling;
import com.gokdenizozkan.n11talenthub.asgn1.entity.Area;
import com.gokdenizozkan.n11talenthub.asgn1.misc.DwellingType;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AreaBuilder {
    public static Area buildTestArea() {
        List<Dwelling> dwellingsTest = Stream.of(
                DwellingBuilder.create(DwellingType.HOUSE)
                        .withRoomCount(2)
                        .withLivingRoomCount(1)
                        .withSquareMeters(100.0)
                        .withPricePerSquareMeter(1000.0)
                        .build(3),
                DwellingBuilder.create(DwellingType.VILLA)
                        .withRoomCount(4)
                        .withLivingRoomCount(2)
                        .withSquareMeters(200.0)
                        .withPricePerSquareMeter(2000.0)
                        .build(3),
                DwellingBuilder.create(DwellingType.HOLIDAY_HOME)
                        .withRoomCount(3)
                        .withLivingRoomCount(1)
                        .withSquareMeters(150.0)
                        .withPricePerSquareMeter(1500.0)
                        .build(3)
        ).flatMap(List::stream).collect(Collectors.toList());

        return new Area(dwellingsTest);
    }
}
