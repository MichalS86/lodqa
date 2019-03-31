import com.lodqa.calculator.calc.SurfaceCounter2d;
import com.lodqa.container.model.GeometryFigure;
import com.lodqa.container.model.GeometryName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SurfaceCountTest {

    @Test
    public void shouldBeSquareSurfceCountWhenCounterTrigger() {
        GeometryFigure square = new GeometryFigure();
        square.setName(GeometryName.SQUARE);
        square.setDimensions(new HashMap<String, Double>() {{
            put("a", 5d);
        }});

        SurfaceCounter2d surfaceCounter2d = new SurfaceCounter2d();
        double countSquareSurface = surfaceCounter2d.countSquareSurface(square);

        assertEquals(25, countSquareSurface, "Invalid surface for square");
    }

    @Test
    public void shouldBeTriangleSurfceCountWhenCounterTrigger() {
        GeometryFigure triangle = new GeometryFigure();
        triangle.setName(GeometryName.TRIANGLE);
        triangle.setDimensions(new HashMap<String, Double>() {{
            put("a", 5d);
            put("h", 2d);
        }});

        SurfaceCounter2d surfaceCounter2d = new SurfaceCounter2d();
        double countTriangleSurface = surfaceCounter2d.countTriangleSurface(triangle);

        assertEquals(5, countTriangleSurface, "Invalid surface for triangle");
    }
}