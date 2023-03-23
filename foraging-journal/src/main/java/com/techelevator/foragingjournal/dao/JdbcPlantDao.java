package com.techelevator.foragingjournal.dao;

import com.techelevator.foragingjournal.model.Plant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcPlantDao implements PlantDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcPlantDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Plant> findAllPlants() {
        List<Plant> plants = new ArrayList<>();
        String sql = "SELECT plant_name FROM plant;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Plant plant = mapRowToPlant(results);
            plants.add(plant);
        }
        return plants;
    }
    @Override
    public List<Plant> findPlantByLocationName(String locationName) {
        List<Plant> plants = new ArrayList<>();
        String sql = "SELECT plant_name\n" +
                "FROM plant\n" +
                "\tJOIN plant_location ON plant_location.plant_id = plant.plant_id\n" +
                "\tJOIN location ON location.location_id = plant_location.location_id\n" +
                "WHERE location_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, locationName);
        while(results.next()){
            Plant plant = mapRowToPlant(results);
            plants.add(plant);
        }
        return plants;
    }

    private Plant mapRowToPlant(SqlRowSet rs){
        Plant plant = new Plant();
        plant.setPlantId(rs.getInt("plant_id"));
        plant.setPlantName(rs.getString("plant_name"));
        plant.setScientificName(rs.getString("scientific_name"));
        plant.setDescription(rs.getString("description"));
        return plant;
    }
}
