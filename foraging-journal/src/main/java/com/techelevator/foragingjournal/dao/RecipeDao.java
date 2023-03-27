package com.techelevator.foragingjournal.dao;

import com.techelevator.foragingjournal.model.Location;
import com.techelevator.foragingjournal.model.Recipe;

import java.util.List;

public interface RecipeDao {
    List<Recipe> findAllRecipes();
    List<Recipe> findRecipeByPlantName(String plantName);
}
