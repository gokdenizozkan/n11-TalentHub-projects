package com.gokdenizozkan.n11talenthub.asgn1.service;

import com.gokdenizozkan.n11talenthub.asgn1.blueprint.Dwelling;
import com.gokdenizozkan.n11talenthub.asgn1.misc.DwellingType;

import java.util.List;
import java.util.stream.Collectors;

public class DwellingService {
    private List<Dwelling> dwellings;

    private DwellingService() {
    }

    public DwellingService(List<Dwelling> dwellings) {
        this.dwellings = dwellings;
    }

    public Double calculateTotalPriceOf(DwellingType dwellingType) {
        return dwellings.stream()
                .filter(dwelling -> dwelling.getClass() == dwellingType.getDwellingClass())
                .mapToDouble(Dwelling::calculatePrice)
                .sum();
    }

    public Double calculateTotalPriceOfAllDwellings() {
        return dwellings.stream()
                .mapToDouble(Dwelling::calculatePrice)
                .sum();
    }

    public Double calculateAverageSquareMetersOf(DwellingType dwellingType) {
        return dwellings.stream()
                .filter(dwelling -> dwelling.getClass() == dwellingType.getDwellingClass())
                .mapToDouble(Dwelling::getSquareMeters)
                .average()
                .orElse(0);
    }


    public Double calculateAverageSquareMetersOfAllDwellings() {
        return dwellings.stream()
                .mapToDouble(Dwelling::getSquareMeters)
                .average()
                .orElse(0);
    }

    public List<Dwelling> filterDwellingsByRoomAndLivingRoomCount(int roomCount, int livingRoomCount) {
        return dwellings.stream()
                .filter(dwelling -> dwelling.getRoomCount() == roomCount && dwelling.getLivingRoomCount() == livingRoomCount)
                .collect(Collectors.toList());
    }
}
