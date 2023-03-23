package com.techelevator.foragingjournal.dao;

import com.techelevator.foragingjournal.model.Location;

import java.util.List;

public interface LocationDao {

    List<Location> findAllLocations();
    List<Location> findLocationByPlantName(String plantName);
}
