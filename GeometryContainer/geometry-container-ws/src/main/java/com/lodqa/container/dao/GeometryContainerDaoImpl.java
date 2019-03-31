package com.lodqa.container.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lodqa.container.model.GeometryFigure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.UUID;

public class GeometryContainerDaoImpl implements GeometryContainerDao {

    private static final Logger LOG = LoggerFactory.getLogger(GeometryContainerDaoImpl.class);
    private ObjectMapper mapper = new ObjectMapper();

    private static final String GET_GEOMETRY = "SELECT id, geometry_type, name, dimensions, surface, volume FROM geometry where id = ?";
    private static final String ADD_GEOMETRY = "INSERT INTO geometry (id, geometry_type, name, dimensions, surface, volume) VALUES (?,?,?,?,0,0)";
    private static final String DELETE_GEOMETRY = "DELETE FROM geometry WHERE id = ?";
    private static final String UPDATE_SURFACE = "UPDATE geometry SET surface = ? WHERE id = ?";
    private static final String UPDATE_VOLUME = "UPDATE geometry SET volume = ? WHERE id = ?";

    private JdbcTemplate jdbcTemplate;

    public GeometryContainerDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public UUID addGeometry(GeometryFigure geometryFigure) {
        try {
            jdbcTemplate.update(ADD_GEOMETRY, geometryFigure.getId().toString(), geometryFigure.getGeometryType(), geometryFigure.getName(), mapper.writeValueAsString(geometryFigure.getDimensions()));
            LOG.info("Geometry with id {} inserted", geometryFigure.getId());
            return geometryFigure.getId();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public GeometryFigure getGeometry(UUID id) {
        return (GeometryFigure) jdbcTemplate.queryForObject(GET_GEOMETRY, new Object[]{id.toString()}, new GeometryRowMapper());
    }

    @Override
    public void updateSurface(UUID id, double surface) {
        jdbcTemplate.update(UPDATE_SURFACE, surface, id.toString());
    }

    @Override
    public void updateVolume(UUID id, double volume) {
        jdbcTemplate.update(UPDATE_VOLUME, volume, id.toString());
    }

    @Override
    public void deleteGeometry(UUID id) {
        jdbcTemplate.update(DELETE_GEOMETRY, id.toString());
    }
}
