package lozm.monthlyChallenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Test3 {


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
        List<int[]> caseList = new ArrayList<>();

        public Graph(int aIndex, int aValue) {
            this.aIndex = aIndex;
            this.aValue = aValue;
        }

        public void addCaseList(int[] caseItem) {
            caseList.add(caseItem);
        }


        @Override
        public int compareTo(Object o) {
            Graph o1 = (Graph) o;
            return this.caseList.size() >= o1.caseList.size() ? 1 : -1;
        }
    }

    public int solution(int[] a, int[][] edges) {
        // a 가 모두 0 인지 확인
        int[] allZeroArray = new int[a.length];
        if (Arrays.equals(a, allZeroArray)) {
            return 0;
        }

        Map<Integer, Graph> caseMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            for (int aIndex : edges[i]) {

                Graph graph = null;
                if (caseMap.containsKey(aIndex)) {
                    graph = caseMap.get(aIndex);
                } else {
                    graph = new Graph(aIndex, a[aIndex]);
                }

                graph.addCaseList(edges[i]);
                caseMap.put(aIndex, graph);
            }
        }

        int answer = 0;
        for (Integer integer : caseMap.keySet()) {
            Graph graph1 = caseMap.get(integer);


            Graph graph2 = null;
            for (int[] ints1 : graph1.caseList) {
                int other = ints1[0] == integer ? ints1[1] : ints1[0];
                Graph otherGraph = caseMap.get(other);
                if (otherGraph.aValue != 0) {
                    graph2 = otherGraph;
                }
            }

            while (graph2 != null && graph1.aValue != 0) {
                if (graph1.aValue > 0) {
                    graph1.aValue--;
                    graph2.aValue++;
                } else {
                    graph1.aValue++;
                    graph2.aValue--;
                }

                answer++;
            }

        }

        // edges 요소가 0이 아닌데 간선 정보에 있는지 확인, 없다면 -1
        return answer == 0 ? -1 : answer;
    }

    public int solution1(int[] a, int[][] edges) {
        // a 가 모두 0 인지 확인
        int[] allZeroArray = new int[a.length];
        if (Arrays.equals(a, allZeroArray)) {
            return 0;
        }

        Map<Integer, Graph> caseMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            for (int aIndex : edges[i]) {

                Graph graph = null;
                if (caseMap.containsKey(aIndex)) {
                    graph = caseMap.get(aIndex);
                } else {
                    graph = new Graph(aIndex, a[aIndex]);
                }

                graph.addCaseList(edges[i]);
                caseMap.put(aIndex, graph);
            }
        }

        int answer = 0;
        for (Integer integer : caseMap.keySet()) {
            Graph graph1 = caseMap.get(integer);


            Graph graph2 = null;
            for (int[] ints1 : graph1.caseList) {
                int other = ints1[0] == integer ? ints1[1] : ints1[0];
                Graph otherGraph = caseMap.get(other);
                if (otherGraph.aValue != 0) {
                    graph2 = otherGraph;
                }
            }

            while (graph2 != null && graph1.aValue != 0) {
                if (graph1.aValue > 0) {
                    graph1.aValue--;
                    graph2.aValue++;
                } else {
                    graph1.aValue++;
                    graph2.aValue--;
                }

                answer++;
            }

        }

        // edges 요소가 0이 아닌데 간선 정보에 있는지 확인, 없다면 -1
        return answer == 0 ? -1 : answer;
    }





    public int worstSolution(int[] a, int[][] edges) {
        // a 가 모두 0 인지 확인
        int[] allZeroArray = new int[a.length];
        if (Arrays.equals(a, allZeroArray)) {
            return 0;
        }

        Map<Integer, List<Integer>> caseMap = new TreeMap<>();
        for (int i = 0; i < edges.length; i++) {
            for (int aIndex : edges[i]) {

                List<Integer> edgesIndexList = null;
                if (caseMap.containsKey(aIndex)) {
                    edgesIndexList = caseMap.get(aIndex);
                } else {
                    edgesIndexList = new ArrayList<>();
                }

                edgesIndexList.add(i);
                caseMap.put(aIndex, edgesIndexList);
            }
        }

        // 횟수 확인
        int answer = 0;
        while (true) {
            for (Integer aIndex : caseMap.keySet()) {

            }

            if (Arrays.equals(a, allZeroArray)) {
                break;
            }
        }


        if (answer > 0) {
            return answer;
        }

        // edges 요소가 0이 아닌데 간선 정보에 있는지 확인, 없다면 -1
        return -1;
    }

}
