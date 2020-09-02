package lozm.algorithm;

import java.util.LinkedList;

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

    public void perform(Object visitedNode) {

    }

}
