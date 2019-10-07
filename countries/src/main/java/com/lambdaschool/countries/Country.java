package com.lambdaschool.countries;

public class Country {
    private String name;
    private long population;
    private long landMassSize;
    private int medianAge;

    public Country(String name, long population, long landMassSize, int medianAge) {
        this.name = name;
        this.population = population;
        this.landMassSize = landMassSize;
        this.medianAge = medianAge;
    }

    public Country(Country toClone) {
        this.name = toClone.getName();
        this.population = toClone.getPopulation();
        this.landMassSize = toClone.getLandMassSize();
        this.medianAge = toClone.getMedianAge();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public long getLandMassSize() {
        return landMassSize;
    }

    public void setLandMassSize(int landMassSize) {
        this.landMassSize = landMassSize;
    }

    public int getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(int medianAge) {
        this.medianAge = medianAge;
    }
}
