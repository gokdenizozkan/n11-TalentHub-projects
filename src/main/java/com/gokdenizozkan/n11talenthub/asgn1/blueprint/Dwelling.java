package com.gokdenizozkan.n11talenthub.asgn1.blueprint;

import com.gokdenizozkan.n11talenthub.asgn1.contract.Priceable;

import java.util.ArrayList;
import java.util.List;

public abstract class Dwelling implements Priceable {
    protected Double squareMeters;
    protected Double pricePerSquareMeter;
    protected Integer roomCount;
    protected Integer livingRoomCount;
    List<Priceable> properties;

    public Dwelling() {
        properties = new ArrayList<>();
    }

    @Override
    public Double calculatePrice() {
        if (squareMeters == null || pricePerSquareMeter == null) {
            return 0.0;
        }

        if (properties == null || properties.isEmpty()) {
            return squareMeters * pricePerSquareMeter;
        }

        return (squareMeters * pricePerSquareMeter) + (properties.stream().mapToDouble(Priceable::calculatePrice).sum());
    }

    @Override
    public String toString() {
        return "Dwelling{" +
                "squareMeters=" + squareMeters +
                ", pricePerSquareMeter=" + pricePerSquareMeter +
                ", roomCount=" + roomCount +
                ", livingRoomCount=" + livingRoomCount +
                ", properties=" + properties +
                '}';
    }

    public Double getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(Double squareMeters) {
        this.squareMeters = squareMeters;
    }

    public Double getPricePerSquareMeter() {
        return pricePerSquareMeter;
    }

    public void setPricePerSquareMeter(Double pricePerSquareMeter) {
        this.pricePerSquareMeter = pricePerSquareMeter;
    }

    public Integer getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(Integer roomCount) {
        this.roomCount = roomCount;
    }

    public Integer getLivingRoomCount() {
        return livingRoomCount;
    }

    public void setLivingRoomCount(Integer livingRoomCount) {
        this.livingRoomCount = livingRoomCount;
    }

    public List<Priceable> getProperties() {
        return properties;
    }

    public void setProperties(List<Priceable> properties) {
        this.properties = properties;
    }
}
