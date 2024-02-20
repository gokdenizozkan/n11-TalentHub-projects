# Assignment 1

n11 TalentHub Bootcamp, 30 days of Java, Spring Boot projects organized by Patika.dev

Assignment 1:

```
Create 3 types of houses: House, Villa, and Holiday Home. 
- In a class, create at least 3 instances of House, Villa, and Holiday Home
    and write the methods that return these instances (getHouseList, getVillaList, etc.).
 
In a service class, write the following methods:
1. A method that returns the total price of the houses
2. A method that returns the total price of the villas
3. A method that returns the total price of the holiday homes
4. A method that returns the total price of all types of houses
5. A method that returns the average square meters of the houses
6. A method that returns the average square meters of the villas
7. A method that returns the average square meters of the holiday homes
8. A method that returns the average square meters of all types of houses
9. A method that filters and returns all types of houses by the number of rooms and living rooms

Note:
- Pay attention to the naming in English.
- Design according to object-oriented programming.
- Follow the principles of clean code.
- In the main method, print all methods to the console in a meaningful way.
```

## Table of Contents

- [Assignment 1](#assignment-1)
    - [Dwelling instead of House](#dwelling-instead-of-house)
        - [Dwelling vs House](#dwelling-vs-house)
        - [Dwelling vs Residence](#dwelling-vs-residence)
    - [Class Diagram](#class-diagram)

## Dwelling instead of House

### Dwelling vs House

The word "house" is a very specific term. It refers to a building that is used as a residence for people.
However, the word "dwelling" is a more general term. It refers to any place where people live.
This includes houses, apartments, and other types of buildings.

The word "dwelling" is a more inclusive term that encompasses all types of living spaces.

### Dwelling vs Residence

The word "residence" is more of a state/concept.
Plus, in some languages, residence is used more formally and may refer to a building where business is conducted.

On the other hand, dwelling is a more concrete term and refers to the physical place where people live.

## Class Diagram

``` mermaid
classDiagram
    Dwelling <|.. Priceable
    Dwelling <|-- House
    Dwelling <|-- Villa
    Dwelling <|-- HolidayHome
    DwellingBuilder -- DwellingType
    DwellingBuilder -- Dwelling
    DwellingService -- Dwelling
    Area -- Dwelling
    AreaBuilder -- Area

    class Dwelling {
        -Double squareMeters
        -Double pricePerSquareMeter
        -Integer roomCount
        -Integer livingRoomCount
        -List~Priceable~ properties
        +calculatePrice() : Double
        +toString() : String
    }
    class DwellingBuilder {
        -Double squareMeters
        -Double pricePerSquareMeter
        -Integer roomCount
        -Integer livingRoomCount
        -List~Priceable~ properties
        +create(DwellingType) : DwellingBuilder
        +build() : Dwelling
        +build(int) : List~Dwelling~
        +withSquareMeters(Double) : DwellingBuilder
        +withPricePerSquareMeter(Double) : DwellingBuilder
        +withRoomCount(Integer) : DwellingBuilder
        +withLivingRoomCount(Integer) : DwellingBuilder
        +withProperty(Priceable) : DwellingBuilder
        +withProperties(List~Priceable~) : DwellingBuilder
    }
    class DwellingService {
        +calculateTotalPriceOf(DwellingType) : Double
        +calculateTotalPriceOfAllDwellings() : Double
        +calculateAverageSquareMetersOf(DwellingType) : Double
        +calculateAverageSquareMetersOfAllDwellings() : Double
        +filterDwellingsByRoomAndLivingRoomCount(int, int) : List~Dwelling~
    }
    class DwellingType {
        +HOUSE
        +HOLIDAY_HOME
        +VILLA
        +getDwellingClass() : Class~?~
        +getNoArgsConstructor() : Constructor~?~
    }
    class Priceable {
        +calculatePrice() : Double
    }
    class Area {
        +List~Dwelling~ dwellings
        +DwellingService dwellingService
    }
    class AreaBuilder {
        +buildTestArea() : Area
    }
    class House {
        +House()
    }
    class Villa {
        +Villa()
    }
    class HolidayHome {
        +HolidayHome()
    }
```