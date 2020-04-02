package Graph;

import java.util.LinkedList;

/**
 * Creates and modifies an adjacency list for a undirected graph.
 */
public class AdjacencyList {
    private int numberVertices;
    private LinkedList<Edge>[] adjList;

    static class Edge {
        int i;
        int j;
        int weight;

        Edge(int i, int j, int weight) {
            this.i = i;
            this.j = j;
            this.weight = weight;
        }
    }

    public AdjacencyList(int numberVertices) {
        this.numberVertices = numberVertices;
        adjList = new LinkedList[numberVertices];

        for (int i = 0; i < numberVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int i, int j, int weight) {
        Edge edge = new Edge(i, j, weight);
        adjList[i].addFirst(edge);

        edge = new Edge(j, i, weight);
        adjList[j].addFirst(edge);
    }

    public void printGraph() {
        System.out.println("===============");
        System.out.println("Adjacency List:");
        System.out.println("===============");
        for (int i = 0; i < numberVertices; i++) {
            LinkedList<Edge> list = adjList[i];

            if (list.size() > 0) {
                System.out.print("Vertex " + i + " links to: ");

                for (Edge e : list) {
                    System.out.print(e.j + " (weight: " + e.weight + ")\t");
                }

                System.out.println();
            } else {
                System.out.println("Vertex " + i + " is empty.");
            }
        }
    }
}
