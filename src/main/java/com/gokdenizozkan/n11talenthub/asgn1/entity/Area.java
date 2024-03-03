package com.gokdenizozkan.n11talenthub.asgn1.entity;

import com.gokdenizozkan.n11talenthub.asgn1.blueprint.Dwelling;
import com.gokdenizozkan.n11talenthub.asgn1.misc.DwellingType;
import com.gokdenizozkan.n11talenthub.asgn1.service.DwellingService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Area {
    private List<Dwelling> dwellings;
    private DwellingService dwellingService;

    private Area() {
        dwellings = new ArrayList<>();
    }

    public Area(List<Dwelling> dwellings) {
        this.dwellings = dwellings;
        dwellingService = new DwellingService(dwellings);
    }

    public DwellingService getDwellingService() {
        return dwellingService;
    }

    public List<Dwelling> getDwellings() {
        return dwellings;
    }

    public List<Dwelling> getDwellingsByType(DwellingType dwellingType) {
        return dwellings.stream()
                .filter(dwelling -> dwelling.getClass() == dwellingType.getDwellingClass())
                .collect(Collectors.toList());
    }

    // for assignment
    public List<House> getHouses() {
        return getDwellingsByType(DwellingType.HOUSE).stream()
                .map(dwelling -> (House) dwelling)
                .collect(Collectors.toList());
    }

    public List<Villa> getVillas() {
        return getDwellingsByType(DwellingType.VILLA).stream()
                .map(dwelling -> (Villa) dwelling)
                .collect(Collectors.toList());
    }

    public List<HolidayHome> getHolidayHomes() {
        return getDwellingsByType(DwellingType.HOLIDAY_HOME).stream()
                .map(dwelling -> (HolidayHome) dwelling)
                .collect(Collectors.toList());
    }
}
