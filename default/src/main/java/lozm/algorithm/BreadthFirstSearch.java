package lozm.algorithm;


import java.util.LinkedList;
import java.util.ListIterator;

public class BreadthFirstSearch {

    private int nodeNumber;
    private LinkedList<Integer> adjacencyNode[];

    private int distance[];
    private int predecessor[];

    public BreadthFirstSearch(int nodeNumber) {
        this.nodeNumber = nodeNumber;
        this.adjacencyNode = new LinkedList[nodeNumber];

        for (int i = 0; i < nodeNumber; i++) {
            this.adjacencyNode[i] = new LinkedList<>();
        }

        this.distance = new int[nodeNumber];
        this.predecessor = new int[nodeNumber];
    }

    public void addEdge(int sourceNodeIndex, int targetNodeIndex) {
        this.adjacencyNode[sourceNodeIndex].add(targetNodeIndex);
    }

    public void search(int visitedNodeIndex) {
        boolean[] visited = new boolean[nodeNumber];
        LinkedList<Integer> queue = new LinkedList<>();

        distance[visitedNodeIndex] = 0;
        predecessor[visitedNodeIndex] = -1;

        //현재 노드 방문 체크
        visited[visitedNodeIndex] = true;
        queue.add(visitedNodeIndex);

        while (queue.size() != 0) {
            int currentNodeIndex = queue.poll();
            System.out.println(currentNodeIndex+ " ");

            //현재 방문한 노드의 인접 노드를 모두 가져옴
            ListIterator<Integer> integerListIterator = adjacencyNode[currentNodeIndex].listIterator();
            while (integerListIterator.hasNext()) {
                int nodeIndex = integerListIterator.next();
                if(!visited[nodeIndex]) {
                    visited[nodeIndex] = true;
                    queue.add(nodeIndex);

                    distance[nodeIndex] = distance[currentNodeIndex] + 1;
                    predecessor[nodeIndex] = currentNodeIndex;
                }
            }
        }
    }

    public void printShortestPath(int startNodeIndex, int endNodeIndex) {
        if(startNodeIndex == endNodeIndex) System.out.println(startNodeIndex);
        else if(predecessor[endNodeIndex] == -1) {
            System.out.println("There is no path from start("+startNodeIndex+") to end("+endNodeIndex+")");
        } else {
            printShortestPath(startNodeIndex, predecessor[endNodeIndex]);
            System.out.println(endNodeIndex);
        }
    }

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

}
