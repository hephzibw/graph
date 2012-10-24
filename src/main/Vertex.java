package main;

import java.util.*;

public class Vertex implements Comparable<Vertex> {
    public static final LinkedList<String> colors = new LinkedList<String>(Arrays.asList("Red", "Yellow", "Green", "Blue"));
    public String color;
    public int id;
    private List<Vertex> neighbours;
    private int degree;

    public Vertex(int id, String color) {
        this.id = id;
        this.color = color;
        this.neighbours = new ArrayList<Vertex>();
        this.degree = 0;
    }

    public List<Vertex> getNeighbours() {
        return neighbours;
    }

    public int getDegree() {
        return degree;
    }

    public void addNewNeighbour(Vertex vertex) {
        this.neighbours.add(vertex);
        this.degree = degree + 1;
    }

    //-1 for less, 0 for equals, 1 for greater
    @Override
    public int compareTo(Vertex vertex) {
        if (vertex.degree == this.degree) {
            return 0;
        } else {
            if (this.degree > vertex.degree) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public String chooseColor() {
        System.out.println(id);
        int index = 0;
        color = colors.get(index);
        Iterator iterator = this.getNeighbours().iterator();
        while (iterator.hasNext()) {
            Vertex current = (Vertex) iterator.next();
            if (current.color != null) {
                if (current.color.equals(color)) {
                    index += 1;
                    color = colors.get(index);
                } else {
                    break;
                }
            }
        }
        return color;
    }
}
