package test;

import junit.framework.Assert;
import main.Graph;
import main.Vertex;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: hephzibah
 * Date: 10/24/12
 * Time: 6:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class GraphTest {
    @Test
    public void itShouldInitializeANewGraph() {
        Graph graph = Graph.createGraph();
        Assert.assertNotNull(graph);
    }

    @Test
    public void itShouldAddTheVertexToAdjacencyListIfNotFoundAndAddToTheVertexNeighbours() {
        Graph graph = Graph.createGraph();
        Vertex vertex1 = new Vertex(1, null);
        Vertex vertex2 = new Vertex(2, null);
        graph.addEdge(vertex1, vertex2);
        assertEquals(graph.adjacencyList.size(), 2);
        assertTrue(vertex1.getNeighbours().contains(vertex2));
        assertTrue(vertex2.getNeighbours().contains(vertex1));
    }

    @Test
    public void itShouldNotItemToAdjacencyListIfAlreadyPresent() {
        Graph graph = Graph.createGraph();
        Vertex vertex1 = new Vertex(1, null);
        graph.adjacencyList.add(vertex1);
        graph.addEdge(vertex1, new Vertex(2, null));
        assertEquals(graph.adjacencyList.size(), 2);
    }

    @Test
    public void itShouldSortTheGraphByDegree() {
        Graph graph = Graph.createGraph();
        Vertex vertex1 = new Vertex(1, null);
        Vertex vertex2 = new Vertex(2, null);
        Vertex vertex3 = new Vertex(3, null);
        Vertex vertex4 = new Vertex(1, null);
        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex1, vertex3);
        graph.addEdge(vertex1, vertex4);
        graph.addEdge(vertex2, vertex3);

        graph.sortByDegree();

        assertEquals(graph.adjacencyList.get(0), vertex4);
        assertEquals(graph.adjacencyList.get(1), vertex2);
        assertEquals(graph.adjacencyList.get(2), vertex3);
        assertEquals(graph.adjacencyList.get(3), vertex1);
    }

    @Test
    public void itShouldAssignColorToAllTheVertices() {
        Graph graph = Graph.createGraph();
        Vertex vertex1 = new Vertex(1, null);
        Vertex vertex2 = new Vertex(2, null);
        Vertex vertex3 = new Vertex(3, null);
        Vertex vertex4 = new Vertex(4, null);
        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex1, vertex3);
        graph.addEdge(vertex1, vertex4);
        graph.addEdge(vertex2, vertex3);

        graph.sortByDegree();
        assertEquals(graph.assignColor(), 3);
        assertEquals(graph.adjacencyList.get(0).color, "Red");
        assertEquals(graph.adjacencyList.get(1).color, "Red");
        assertEquals(graph.adjacencyList.get(2).color, "Yellow");
        assertEquals(graph.adjacencyList.get(3).color, "Green");
    }
}
