package lozm.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.ListIterator;

public class SharedTaxiFare {

    @Test
    public void testCase1() {
        // Given
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        // When
        int solution = solution(n, s, a, b, fares);

        // Then
        Assertions.assertEquals(82, solution);
    }

    @Test
    public void testCase2() {
        // Given
        int n = 7;
        int s = 3;
        int a = 4;
        int b = 1;
        int[][] fares = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};

        // When
        int solution = solution(n, s, a, b, fares);

        // Then
        Assertions.assertEquals(14, solution);
    }

    @Test
    public void testCase3() {
        // Given
        int n = 6;
        int s = 4;
        int a = 5;
        int b = 6;
        int[][] fares = {{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}};

        // When
        int solution = solution(n, s, a, b, fares);

        // Then
        Assertions.assertEquals(18, solution);
    }

    /**
     * 합승 택시 요금
     * https://programmers.co.kr/learn/courses/30/lessons/72413
     *
     * 지점의 개수 n
     * 출발지점을 나타내는 s
     * A의 도착지점을 나타내는 a
     * B의 도착지점을 나타내는 b
     * 지점 사이의 예상 택시요금을 나타내는 fares
     *
     * 1. A, B 두 사람이 s에서 출발해서 각각의 도착 지점까지 택시를 타고 간다
     * 2. 최저 예상 택시요금을 계산해서 return
     * 3. 만약, 아예 합승을 하지 않고 각자 이동하는 경우의 예상 택시요금이 더 낮다면, 합승을 하지 않아도 됩니다
     */
    public int solution(int n, int s, int a, int b, int[][] fares) {
        BreadthFirstSearch bfs = new BreadthFirstSearch(n);

        for (int[] fare : fares) {

        }


        int answer = 0;
        return answer;
    }

    class BreadthFirstSearch {
        private int nodeNumber;
        private LinkedList<Integer> adjacencyNode[];
        private int[] distance;
        private int[] predecessor;
        private boolean[] visited;

        public BreadthFirstSearch(int nodeNumber) {
            this.nodeNumber = nodeNumber + 1;
            this.adjacencyNode = new LinkedList[this.nodeNumber];

            for (int i = 0; i < this.nodeNumber; i++) {
                adjacencyNode[i] = new LinkedList<>();
            }

            this.distance = new int[this.nodeNumber];
            this.predecessor = new int[this.nodeNumber];
            this.visited = new boolean[this.nodeNumber];
        }

        public void addEdge(int source, int target) {
            this.adjacencyNode[source].add(target);
        }

        public void search(int[] passenger, int start) {
            LinkedList<Integer> queue = new LinkedList<>();

            distance[start] = passenger[start-1];
            predecessor[start] = -1;

            visited[start] = true;
            queue.add(start);

            while (queue.size() != 0) {
                int current = queue.poll();

                ListIterator<Integer> integerListIterator = adjacencyNode[current].listIterator();
                while (integerListIterator.hasNext()) {
                    Integer adjacency = integerListIterator.next();

                    if (!visited[adjacency]) {
                        visited[adjacency] = true;
                        queue.add(adjacency);

                        distance[adjacency] = distance[current] + passenger[adjacency-1];
                        predecessor[adjacency] = current;
                    }
                }
            }
        }

        public int[] getAnswer() {
            int maxIndex = 0;
            int maxValue = distance[maxIndex];

            for (int i = 0; i < distance.length; i++) {
                if (distance[i] > maxValue) {
                    maxIndex = i;
                    maxValue = distance[i];
                }
            }

            for (int i = 0; i < distance.length; i++) {
                if (distance[i] == maxValue && maxIndex < i) {
                    maxIndex = i;
                }
            }

            int[] answer = new int[2];
            answer[0] = maxIndex;
            answer[1] = maxValue;

            return answer;
        }
    }

}
