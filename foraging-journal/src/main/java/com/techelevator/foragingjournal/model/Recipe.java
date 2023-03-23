package com.techelevator.foragingjournal.model;

public class Recipe {
    private int recipeId;
    private String name;
    private String ingredients;
    private String description;

    public Recipe(int recipeId, String name, String ingredients, String description){
        this.recipeId = recipeId;
        this.name = name;
        this.ingredients = ingredients;
        this.description = description;
    }

    public int getRecipeId() {
        return recipeId;
    }
    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
