package com.lodqa.container.service;

import com.lodqa.container.dao.GeometryContainerDao;
import com.lodqa.container.dao.GeometryContainerDaoImpl;
import com.lodqa.container.model.GeometryFigure;
import com.lodqa.container.model.GeometryService;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GeometryServiceImpl implements GeometryService {

    private GeometryContainerDao geometryDao;

    public GeometryServiceImpl(@Value("${spring.datasource.url}") String url, @Value("${spring.datasource.user}") String user,
                               @Value("${spring.datasource.password}") String password) {
        MysqlDataSource mysqlDS = new MysqlDataSource();
        mysqlDS.setURL(url);
        mysqlDS.setUser(user);
        mysqlDS.setPassword(password);

        geometryDao = new GeometryContainerDaoImpl(mysqlDS);
    }

    @Override
    public UUID addGeometry(GeometryFigure geometryFigure) {
        return geometryDao.addGeometry(geometryFigure);
    }

    @Override
    public GeometryFigure getGeometry(UUID id) {
        return geometryDao.getGeometry(id);
    }

    @Override
    public void updateSurface(UUID id, double surface) {
        geometryDao.updateSurface(id, surface);
    }

    @Override
    public void updateVolume(UUID id, double volume) {
        geometryDao.updateVolume(id, volume);
    }

    @Override
    public void deleteGeometry(UUID id) {
        geometryDao.deleteGeometry(id);
    }
}
