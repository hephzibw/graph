package main;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: hephzibah
 * Date: 10/24/12
 * Time: 5:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class Graph {
    public List<Vertex> adjacencyList;

    public Graph() {
        this.adjacencyList = new ArrayList<Vertex>();
    }

    public static Graph createGraph() {
        return new Graph();
    }

    public void addEdge(Vertex vertex1, Vertex vertex2) {
        if (newVertex(vertex1)) {
            this.adjacencyList.add(vertex1);
        }
        if (newVertex(vertex2)) {
            this.adjacencyList.add(vertex2);
        }
        vertex1.addNewNeighbour(vertex2);
        vertex2.addNewNeighbour(vertex1);
    }

    private Boolean newVertex(Vertex vertex) {
        Boolean outcome = true;
        if (this.adjacencyList.contains(vertex)) {
            outcome = false;
        }
        return outcome;
    }

    public void sortByDegree() {
        Collections.sort(this.adjacencyList);
    }

    public int assignColor() {
        ArrayList<String> colors = new ArrayList<String>();
        Iterator iterator = this.adjacencyList.iterator();
        while (iterator.hasNext()) {
            Vertex current = (Vertex) iterator.next();
            String color = current.chooseColor();
            current.color = color;
            if (!colors.contains(color)) {
                colors.add(color);
            }
        }
        return colors.size();
    }
}
