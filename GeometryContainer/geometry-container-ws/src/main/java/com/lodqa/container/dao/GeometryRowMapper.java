package com.lodqa.container.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lodqa.container.model.GeometryFigure;
import org.springframework.jdbc.core.RowMapper;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GeometryRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Double> map = new HashMap<>();
        try {
            map = mapper.readValue(rs.getString("dimensions"), HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        GeometryFigure geometryFigure = new GeometryFigure(
                UUID.fromString(rs.getString("id")), rs.getString("geometry_type"), rs.getString("name"),
                map, rs.getFloat("surface"), rs.getFloat("volume"));
        return geometryFigure;
    }
}
