package test;

import main.Vertex;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: hephzibah
 * Date: 10/24/12
 * Time: 9:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class VertexTest {

    @Test
    public void testTheConstructor() {
        Vertex vertex = new Vertex(12, "Red");
        assertEquals(vertex.color, "Red");
        assertEquals(vertex.id, 12);
        assertEquals(vertex.getNeighbours().size(), 0);
        assertEquals(vertex.getDegree(), 0);
    }

    @Test
    public void itShouldAddNewNeighbourAndIncreaseDegree() {
        Vertex vertex1 = new Vertex(1, null);
        Vertex vertex2 = new Vertex(2, null);
        vertex1.addNewNeighbour(vertex2);
        assertEquals(vertex1.getDegree(), 1);
        assertTrue(vertex1.getNeighbours().contains(vertex2));
    }

    @Test
    public void shouldChooseTheFirstColorInTheListIfNoNeighBourAlreadyHasThatColor(){
        Vertex vertex1 = new Vertex(1, null);
        Vertex vertex2 = new Vertex(2, "Red");
        Vertex vertex3 = new Vertex(2, "Yellow");
        vertex1.addNewNeighbour(vertex2);
        vertex1.addNewNeighbour(vertex3);
        assertEquals(vertex1.chooseColor(),"Green");
    }

    @Test
    public void shouldBeGreedyToChooseTheMinColorFromList(){
        Vertex vertex1 = new Vertex(1, null);
        Vertex vertex2 = new Vertex(2, "Red");
        Vertex vertex3 = new Vertex(2, "Green");
        vertex1.addNewNeighbour(vertex2);
        vertex1.addNewNeighbour(vertex3);
        assertEquals(vertex1.chooseColor(),"Yellow");

    }

}
