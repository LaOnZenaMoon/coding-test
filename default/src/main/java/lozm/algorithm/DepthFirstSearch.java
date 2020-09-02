package lozm.algorithm;

import java.util.LinkedList;
import java.util.ListIterator;

public class DepthFirstSearch {

    private int nodeNumber;
    private LinkedList<Integer> adjacencyNode[];

    public DepthFirstSearch(int nodeNumber) {
        this.nodeNumber = nodeNumber;
        adjacencyNode = new LinkedList[nodeNumber];

        for (int i = 0; i < nodeNumber; i++) {
            adjacencyNode[i] = new LinkedList<>();
        }
    }

    public void addEdge(int sourceNodeIndex, int targetNodeIndex) {
        adjacencyNode[sourceNodeIndex].add(targetNodeIndex);
    }

    public void checkIsVisitedNode(int visitedNodeIndex, boolean visited[]) {
        //현재 노드 방문 체크
        visited[visitedNodeIndex] = true;
        System.out.println(visitedNodeIndex + " ");

        ListIterator<Integer> integerListIterator = adjacencyNode[visitedNodeIndex].listIterator();
        while (integerListIterator.hasNext()) {
            int currentNodeIndex = integerListIterator.next();

            if(!visited[currentNodeIndex]) {
                checkIsVisitedNode(currentNodeIndex, visited);
            }
        }
    }

    public void search() {
        boolean[] visited = new boolean[nodeNumber];

        for (int i = 0; i < nodeNumber; i++) {
            if(visited[i] == false) checkIsVisitedNode(i, visited);
        }
    }

    public void search(int startNodeIndex) {
        boolean[] visited = new boolean[nodeNumber];

        checkIsVisitedNode(startNodeIndex, visited);
    }

    public static void main(String args[]) {
        DepthFirstSearch g = new DepthFirstSearch(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.search(2); /* 주어진 노드를 시작 노드로 DFS 탐색 */
        g.search(); /* 비연결형 그래프의 경우 */
    }

}
