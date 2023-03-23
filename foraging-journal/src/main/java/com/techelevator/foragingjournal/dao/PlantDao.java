package com.techelevator.foragingjournal.dao;

import com.techelevator.foragingjournal.model.Plant;

import java.util.List;

public interface PlantDao {

    List<Plant> findAllPlants();
    List<Plant> findPlantByLocationName(String locationName);
}
