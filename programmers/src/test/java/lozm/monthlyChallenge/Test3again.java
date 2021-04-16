package lozm.monthlyChallenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Test3again {


    @Test
    public void testCase1() {
        // Given
        int[] a = {-5, 0, 2, 1, 2};
        int[][] edges = {{0, 1}, {3, 4}, {2, 3}, {0, 3}};

        // When
        int solution = solution(a, edges);

        // Then
        Assertions.assertEquals(9, solution);
    }

    @Test
    public void testCase2() {
        // Given
        int[] a = {0, 1, 0};
        int[][] edges = {{0, 1}, {1, 2}};

        // When
        int solution = solution(a, edges);

        // Then
        Assertions.assertEquals(-1, solution);
    }

    @Test
    public void testCase3() {
        // Given
        int[] a = {0, 0, 0, 0, 0};
        int[][] edges = {{0, 1}, {3, 4}, {2, 3}, {0, 3}};

        // When
        int solution = solution(a, edges);

        // Then
        Assertions.assertEquals(0, solution);
    }

    class Process {
        int aIndex;
        int aValue;
        List<Integer> relatedEdgeIndexList = new ArrayList<>();
    }

    /**
     * 조건
     * 트리의 각 점의 가중치를 의미하는 1차원 정수 배열 a
     * 트리의 간선 정보를 의미하는 edges
     * 주어진 행동을 통해 트리의 모든 점들의 가중치를 0으로 만드는 것이 불가능하다면 -1
     * 가능하다면 최소 몇 번만에 가능한지를 찾아 return
     * 만약 처음부터 트리의 모든 정점의 가중치가 0이라면, 0을 return
     */

    class Graph implements Comparable{
        int aIndex;
        int aValue;
        List<Integer> adjacencyList = new ArrayList<>();

        public Graph(int aIndex, int aValue) {
            this.aIndex = aIndex;
            this.aValue = aValue;
        }

        public void addAdjacency(Integer caseItem) {
            adjacencyList.add(caseItem);
        }


        @Override
        public int compareTo(Object o) {
            Graph o1 = (Graph) o;
            return this.adjacencyList.size() >= o1.adjacencyList.size() ? 1 : -1;
        }
    }

    public int solution(int[] a, int[][] edges) {
        // a 가 모두 0 인지 확인
        int[] allZeroArray = new int[a.length];
        if (Arrays.equals(a, allZeroArray)) {
            return 0;
        }

        // Graph 클래스로 데이터 변환
        Map<Integer, Graph> caseMap = new HashMap<>();
        for (int[] edge : edges) {
            int first = edge[0];
            Graph firstGraph = caseMap.containsKey(first) ? caseMap.get(first) : new Graph(first, a[first]);

            int second = edge[1];
            Graph secondGraph = caseMap.containsKey(second) ? caseMap.get(second) : new Graph(second, a[second]);

            firstGraph.addAdjacency(second);
            secondGraph.addAdjacency(first);

            caseMap.put(first, firstGraph);
            caseMap.put(second, secondGraph);
        }

        System.out.println("caseMap = " + caseMap);

        int answer = 0;
        for (Integer aIndex : caseMap.keySet()) {
            Graph firstGraph = caseMap.get(aIndex);

            // find second target
            Graph secondGraph = null;
            for (Integer secondIndex : firstGraph.adjacencyList) {
                Graph tempGraph = caseMap.get(secondIndex);
                if (tempGraph.aValue != 0) {
                    secondGraph = tempGraph;
                    break;
                }
            }

            while (secondGraph != null && firstGraph.aValue != 0) {
                if (firstGraph.aValue > 0) {
                    firstGraph.aValue--;
                    secondGraph.aValue++;
                } else {
                    firstGraph.aValue++;
                    secondGraph.aValue--;
                }

                answer++;
            }

        }

        // edges 요소가 0이 아닌데 간선 정보에 있는지 확인, 없다면 -1
        return answer == 0 ? -1 : answer;
    }

}
