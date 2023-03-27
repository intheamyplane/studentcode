package com.techelevator.foragingjournal.controller;

import com.techelevator.foragingjournal.dao.LocationDao;
import com.techelevator.foragingjournal.dao.PlantDao;
import com.techelevator.foragingjournal.dao.RecipeDao;
import com.techelevator.foragingjournal.model.Plant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;

import java.util.List;

public class AppController {
    private PlantDao plantDao;
    private LocationDao locationDao;
    private RecipeDao recipeDao;

    public AppController(PlantDao plantDao, LocationDao locationDao, RecipeDao recipeDao){
        this.plantDao = plantDao;
        this.locationDao = locationDao;
        this.recipeDao = recipeDao;
    }

    @RequestMapping(path = "/plants", method = RequestMethod.GET)
    public List<Plant> listPlants() {return plantDao.findAllPlants();}






}
