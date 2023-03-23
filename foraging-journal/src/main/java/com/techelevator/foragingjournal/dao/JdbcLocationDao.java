package com.techelevator.foragingjournal.dao;

import com.techelevator.foragingjournal.model.Location;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcLocationDao implements LocationDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcLocationDao(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<Location> findAllLocations() {
        List<Location> locations = new ArrayList<>();
        String sql = "SELECT location_name FROM location;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Location location = mapRowToLocation(results);
            locations.add(location);
        }
        return locations;
    }

    @Override
    public List<Location> findLocationByPlantName(String plantName) {
        List<Location> locations = new ArrayList<>();
        String sql = "SELECT location_name\n" +
                "FROM location\n" +
                "\tJOIN plant_location ON plant_location.location_id = location.location_id\n" +
                "\tJOIN plant ON plant.plant_id = plant_location.plant_id\n" +
                "WHERE plant_name = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, plantName);
        while (results.next()) {
            Location location = mapRowToLocation(results);
            locations.add(location);
        }
        return locations;
    }



   private Location mapRowToLocation(SqlRowSet rs) {
        Location location = new Location();
        location.setLocationId(rs.getInt("location_id"));
        location.setName(rs.getString("location_name"));
        location.setAddress(rs.getString("address"));
        return location;
   }

}
