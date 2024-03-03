package com.gokdenizozkan.n11talenthub.asgn1.builder;

import com.gokdenizozkan.n11talenthub.asgn1.misc.DwellingType;
import com.gokdenizozkan.n11talenthub.asgn1.blueprint.Dwelling;
import com.gokdenizozkan.n11talenthub.asgn1.contract.Priceable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DwellingBuilder {
    private DwellingType dwellingType;
    protected Double squareMeters;
    protected Double pricePerSquareMeter;
    protected Integer roomCount;
    protected Integer livingRoomCount;
    List<Priceable> properties;

    private DwellingBuilder(DwellingType dwellingType) {
        this.dwellingType = dwellingType;
    }

    public static DwellingBuilder create(DwellingType dwellingType) {
        return new DwellingBuilder(dwellingType);
    }

    public Dwelling build() {
        try {
            Dwelling dwelling = (Dwelling) dwellingType.getNoArgsConstructor().newInstance();
            dwelling.setSquareMeters(squareMeters);
            dwelling.setPricePerSquareMeter(pricePerSquareMeter);
            dwelling.setRoomCount(roomCount);
            dwelling.setLivingRoomCount(livingRoomCount);
            dwelling.setProperties(properties);
            return dwelling;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Dwelling> build(int count) {
        return Stream.generate(this::build).limit(count).collect(Collectors.toList());
    }

    public DwellingBuilder withSquareMeters(Double squareMeters) {
        this.squareMeters = squareMeters;
        return this;
    }

    public DwellingBuilder withPricePerSquareMeter(Double pricePerSquareMeter) {
        this.pricePerSquareMeter = pricePerSquareMeter;
        return this;
    }

    public DwellingBuilder withRoomCount(Integer roomCount) {
        this.roomCount = roomCount;
        return this;
    }

    public DwellingBuilder withLivingRoomCount(Integer livingRoomCount) {
        this.livingRoomCount = livingRoomCount;
        return this;
    }

    public DwellingBuilder withProperty(Priceable property) {
        if (properties == null) {
            properties = new ArrayList<>();
        }
        properties.add(property);
        return this;
    }

    public DwellingBuilder withProperties(List<Priceable> properties) {
        this.properties = properties;
        return this;
    }
}
