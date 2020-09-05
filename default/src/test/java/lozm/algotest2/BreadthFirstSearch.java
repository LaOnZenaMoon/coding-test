package lozm.algotest2;

import java.util.LinkedList;
import java.util.ListIterator;

public class BreadthFirstSearch {

    public static void main(String args[]) {
        BreadthFirstSearch g = new BreadthFirstSearch(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.search(2); /* 주어진 노드를 시작 노드로 BFS 탐색 */

        g.printShortestPath(2, 1);
    }

    private void printShortestPath(int start, int end) {
        if(start == end) System.out.println(start);
        else if(predecessor[end] == -1) System.out.println("There is no path");
        else {
            printShortestPath(start, predecessor[end]);
            System.out.println(end);
        }
    }

    private void search(int start) {
        boolean[] visited = new boolean[nodeNumber];
        LinkedList<Integer> queue = new LinkedList<>();

        distance[start] = 0;
        predecessor[start] = -1;

        visited[start] = true;
        queue.add(start);

        while (queue.size() != 0) {
            Integer current = queue.poll();

            ListIterator<Integer> integerListIterator = adjacencyNode[current].listIterator();
            while (integerListIterator.hasNext()) {
                Integer adjacency = integerListIterator.next();

                if(!visited[adjacency]) {
                    visited[adjacency] = true;
                    queue.add(adjacency);

                    distance[adjacency] = distance[current] + 1;
                    predecessor[adjacency] = current;
                }
            }
        }
    }

    private void addEdge(int source, int target) {
        this.adjacencyNode[source].add(target);
    }

    private int nodeNumber;
    private LinkedList<Integer> adjacencyNode[];
    private int[] distance;
    private int[] predecessor;

    public BreadthFirstSearch(int nodeNumber) {
        this.nodeNumber = nodeNumber;
        this.distance = new int[nodeNumber];
        this.predecessor = new int[nodeNumber];
        this.adjacencyNode = new LinkedList[nodeNumber];

        for (int i = 0; i < nodeNumber; i++) {
            adjacencyNode[i] = new LinkedList<>();
        }
    }

}
