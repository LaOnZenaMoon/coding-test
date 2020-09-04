package lozm.algotest;

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
        else if(predecessor[end] == -1) {
            System.out.println("There is no path from start to end.");
        } else {
            printShortestPath(start, predecessor[end]);
            System.out.println(end);
        }
    }

    private void search(int visitedIndex) {
        boolean[] visited = new boolean[nodeNumber];
        LinkedList<Integer> queue = new LinkedList<>();

        distance[visitedIndex] = 0;
        predecessor[visitedIndex] = -1;

        visited[visitedIndex] = true;
        queue.add(visitedIndex);

        while (queue.size() != 0) {
            Integer currentIndex = queue.poll();
            ListIterator<Integer> integerListIterator = adjacency[currentIndex].listIterator();
            while (integerListIterator.hasNext()) {
                Integer adjacencyIndex = integerListIterator.next();

                if(!visited[adjacencyIndex]) {
                    visited[adjacencyIndex] = true;
                    queue.add(adjacencyIndex);
                    distance[adjacencyIndex] = distance[currentIndex] + 1;
                    predecessor[adjacencyIndex] = currentIndex;
                }
            }
        }

    }

    private void addEdge(int source, int target) {
        this.adjacency[source].add(target);
    }

    private int nodeNumber;
    private LinkedList<Integer> adjacency[];
    private int[] distance;
    private int[] predecessor;

    public BreadthFirstSearch(int nodeNumber) {
        this.nodeNumber = nodeNumber;
        this.distance = new int[nodeNumber];
        this.predecessor = new int[nodeNumber];

        adjacency = new LinkedList[nodeNumber];
        for (int i = 0; i < nodeNumber; i++) {
            this.adjacency[i] = new LinkedList<>();
        }
    }

}
