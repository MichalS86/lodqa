package com.lodqa.steps;

import com.lodqa.DbManager;
import com.lodqa.PropertiesHelper;
import com.lodqa.calculator.client.WebGeometryCalculatorClient;
import com.lodqa.container.client.WebGeometryContainerClient;
import com.lodqa.container.model.GeometryFigure;
import com.lodqa.loader.TestDataLoader;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class IntegrationSteps {

    private static final Logger LOG = LoggerFactory.getLogger(IntegrationSteps.class);
    private TestDataLoader loader = new TestDataLoader();
    private PropertiesHelper prop = new PropertiesHelper("test.properties");
    private WebGeometryContainerClient geometryContainerClient = new WebGeometryContainerClient(prop.getPropValue("geometry-container.ws.url"), 30, 30);
    private WebGeometryCalculatorClient geometryCalculatorClient = new WebGeometryCalculatorClient(prop.getPropValue("geometry-calculator.ws.url"), 30, 30);
    private GeometryFigure geometryFigure;

    @Before
    public void cleanDb() {
        DbManager dbManager = new DbManager();
        dbManager.removeGeometryFromDb();
    }

    @Given("^get test geometry with name (.*)")
    public void loadGeometryFromTestDataWithName(String name) {
        LOG.info("Load geometry with name {}", name);
        geometryFigure = loader.getGeometryFigure(name);
    }

    @Given("^get geometry with id (.*)$")
    public void getGeometryWithId(String uuid) {
        GeometryFigure geometry = geometryContainerClient.getGeometry(UUID.fromString(uuid));
        LOG.info("Geometry: {}", geometry.getGeometryType());
    }

    @When("^add geometry to container$")
    public void addGeometryToContainer() {
        geometryContainerClient.addGeometry(geometryFigure);
        LOG.info("Geometry with id {} added to DB", geometryFigure.getId());
    }

    @Then("^correct geometry saved in db")
    public void correcctGeometrySavedInDb() {
        GeometryFigure geometry = geometryContainerClient.getGeometry(geometryFigure.getId());
        LOG.info("geoemtry db: " + geometry.toString());
        LOG.info("geoemtry test: " + geometryFigure.toString());
        Assert.assertTrue(geometry.equals(geometryFigure));
    }

    @When("^count geometry surface$")
    public void countGeometrySurface() {
        geometryCalculatorClient.countSurface(geometryFigure.getId());
    }

    @Then("^geometry figure surface equals (.*)$")
    public void geometryFigureSurfaceEquals(double surface) {
        GeometryFigure geometry = geometryContainerClient.getGeometry(geometryFigure.getId());
        Assert.assertEquals(surface, geometry.getSurface(), 0.05);
    }

    @When("^count geometry volume$")
    public void countGeometryVolume() {
        geometryCalculatorClient.countVolume(geometryFigure.getId());
    }

    @Then("^geometry figure volume equals (.*)$")
    public void geometryFigureVolumeEquals(double volume) {
        GeometryFigure geometry = geometryContainerClient.getGeometry(geometryFigure.getId());
        Assert.assertEquals(volume, geometry.getVolume(), 0.05);
    }

}
