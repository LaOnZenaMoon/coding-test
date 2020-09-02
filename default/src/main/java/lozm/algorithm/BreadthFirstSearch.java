package lozm.algorithm;


import java.util.LinkedList;
import java.util.ListIterator;

public class BreadthFirstSearch {

    private int nodeNumber;
    private LinkedList<Integer> adjacencyNode[];

    public BreadthFirstSearch(int nodeNumber) {
        this.nodeNumber = nodeNumber;
        adjacencyNode = new LinkedList[nodeNumber];

        for (int i = 0; i < nodeNumber; i++) {
            adjacencyNode[i] = new LinkedList<>();
        }
    }

    public void addEdge(int sourceNodeIndex, int targetNodeIndex) {
        adjacencyNode[sourceNodeIndex].add(targetNodeIndex);
    }

    public void perform(int startNodeIndex) {
        boolean[] visited = new boolean[nodeNumber];
        LinkedList<Integer> queue = new LinkedList<>();

        //현재 노드 방문 체크
        visited[startNodeIndex] = true;
        queue.add(startNodeIndex);

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
                }
            }
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

        g.perform(2); /* 주어진 노드를 시작 노드로 BFS 탐색 */
    }

}
