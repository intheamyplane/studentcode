package com.techelevator.foragingjournal.dao;

import com.techelevator.foragingjournal.model.Location;
import com.techelevator.foragingjournal.model.Recipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcRecipeDao implements RecipeDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcRecipeDao(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<Recipe> findAllRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        String sql = "SELECT recipe_name FROM recipe;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Recipe recipe = mapRowToRecipe(results);
            recipes.add(recipe);
        }
        return recipes;
    }

    @Override
    public List<Recipe> findRecipeByPlantName(String plantName) {
        List<Recipe> recipes = new ArrayList<>();
        String sql = "SELECT recipe_name\n" +
                "FROM recipe\n" +
                "\tJOIN recipe_plant ON recipe_plant.recipe_id = recipe.recipe_id\n" +
                "\tJOIN plant ON plant.plant_id = recipe_plant.plant_id\n" +
                "WHERE plant_name = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, plantName);
        while (results.next()) {
            Recipe recipe = mapRowToRecipe(results);
            recipes.add(recipe);
        }
        return recipes;
    }




    private Recipe mapRowToRecipe(SqlRowSet rs) {
        Recipe recipe = new Recipe();
        recipe.setName(rs.getString("recipe_name"));
        recipe.setIngredients(rs.getString("ingredients"));
        recipe.setDescription(rs.getString("description"));

        return recipe;
    }
}
