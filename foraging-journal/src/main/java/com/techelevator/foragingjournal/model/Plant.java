package com.techelevator.foragingjournal.model;

public class Plant {
    private int plantId;
    private String plantName;
    private String scientificName;
    private String description;

    public Plant(){}


    public Plant(int plantId, String plantName, String scientificName, String description){
        this.plantId = plantId;
        this.plantName = plantName;
        this.scientificName = scientificName;
        this.description = description;
    }

    public int getPlantId() {
        return plantId;
    }
    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public String getPlantName() {
        return plantName;
    }
    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getScientificName() {
        return scientificName;
    }
    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
