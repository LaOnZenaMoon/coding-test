package lozm.algotest2;

import java.util.LinkedList;
import java.util.ListIterator;

public class DepthFirstSearch {

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

    private void search() {
        boolean[] visited = new boolean[nodeNumber];

        for (int i = 0; i < nodeNumber; i++) {
            if(visited[i] == false) checkNode(i, visited);
        }
    }

    private void search(int start) {
        boolean[] visited = new boolean[nodeNumber];

        checkNode(start, visited);
    }

    private void checkNode(int start, boolean[] visited) {
        visited[start] = true;
        System.out.println(start);

        ListIterator<Integer> integerListIterator = adjacencyNode[start].listIterator();
        while (integerListIterator.hasNext()) {
            Integer current = integerListIterator.next();

            if(!visited[current]) {
                checkNode(current, visited);
            }
        }
    }

    private void addEdge(int start, int end) {
        this.adjacencyNode[start].add(end);
    }

    private int nodeNumber;
    private LinkedList<Integer> adjacencyNode[];

    public DepthFirstSearch(int nodeNumber) {
        this.nodeNumber = nodeNumber;
        this.adjacencyNode = new LinkedList[nodeNumber];

        for (int i = 0; i < nodeNumber; i++) {
            adjacencyNode[i] = new LinkedList<>();
        }
    }

}
