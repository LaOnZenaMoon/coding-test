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

    /**
     * 문제 설명
     * 각 점에 가중치가 부여된 트리가 주어집니다. 당신은 다음 연산을 통하여, 이 트리의 모든 점들의 가중치를 0으로 만들고자 합니다.
     *
     * 임의의 연결된 두 점을 골라서 한쪽은 1 증가시키고, 다른 한쪽은 1 감소시킵니다.
     * 하지만, 모든 트리가 위의 행동을 통하여 모든 점들의 가중치를 0으로 만들 수 있는 것은 아닙니다. 당신은 주어진 트리에 대해서 해당 사항이 가능한지 판별하고, 만약 가능하다면 최소한의 행동을 통하여 모든 점들의 가중치를 0으로 만들고자 합니다.
     *
     * 트리의 각 점의 가중치를 의미하는 1차원 정수 배열 a와 트리의 간선 정보를 의미하는 edges가 매개변수로 주어집니다. 주어진 행동을 통해 트리의 모든 점들의 가중치를 0으로 만드는 것이 불가능하다면 -1을, 가능하다면 최소 몇 번만에 가능한지를 찾아 return 하도록 solution 함수를 완성해주세요. (만약 처음부터 트리의 모든 정점의 가중치가 0이라면, 0을 return 해야 합니다.)
     *
     * 제한사항
     * a의 길이는 2 이상 300,000 이하입니다.
     * a의 모든 수는 각각 -1,000,000 이상 1,000,000 이하입니다.
     * a[i]는 i번 정점의 가중치를 의미합니다.
     * edges의 행의 개수는 (a의 길이 - 1)입니다.
     * edges의 각 행은 [u, v] 2개의 정수로 이루어져 있으며, 이는 u번 정점과 v번 정점이 간선으로 연결되어 있음을 의미합니다.
     * edges가 나타내는 그래프는 항상 트리로 주어집니다.
     * 입출력 예
     * a	edges	result
     * [-5,0,2,1,2]	[[0,1],[3,4],[2,3],[0,3]]	9
     * [0,1,0]	[[0,1],[1,2]]	-1
     * 입출력 예 설명
     * 입출력 예 #1
     *
     * 다음 그림은 주어진 트리의 모든 정점의 가중치를 0으로 만드는 과정을 나타낸 것입니다.
     *
     *
     * 2번 정점과 3번 정점을 선택하여 2번 정점은 1 감소시키고, 3번 정점은 1 증가시킵니다. (2번 반복)
     * 3번 정점과 4번 정점을 선택하여 4번 정점은 1 감소시키고, 3번 정점은 1 증가시킵니다. (2번 반복)
     * 0번 정점과 3번 정점을 선택하여 3번 정점은 1 감소시키고, 0번 정점은 1 증가시킵니다. (5번 반복)
     * 모든 정점의 가중치를 0으로 만드는 데 필요한 최소 행동 횟수는 9번이므로, 9를 return 해야 합니다.
     * 입출력 예 #2
     *
     * 주어진 트리는 모든 정점의 가중치를 0으로 만드는 것이 불가능하므로, -1을 return 해야 합니다.
     */

    /**
     * 조건
     * 트리의 각 점의 가중치를 의미하는 1차원 정수 배열 a
     * 트리의 간선 정보를 의미하는 edges
     * 주어진 행동을 통해 트리의 모든 점들의 가중치를 0으로 만드는 것이 불가능하다면 -1
     * 가능하다면 최소 몇 번만에 가능한지를 찾아 return
     * 만약 처음부터 트리의 모든 정점의 가중치가 0이라면, 0을 return
     */
    class Graph {
        int aIndex;
        int aValue;
        Map<Integer, Integer> adjacencyMap = new HashMap<>();

        public Graph(int aIndex, int aValue) {
            this.aIndex = aIndex;
            this.aValue = aValue;
        }

        public void addAdjacency(Integer index) {
            adjacencyMap.put(index, index);
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
            Graph firstGraph = caseMap.getOrDefault(first, new Graph(first, a[first]));
            int second = edge[1];
            Graph secondGraph = caseMap.getOrDefault(second, new Graph(second, a[second]));

            firstGraph.addAdjacency(second);
            secondGraph.addAdjacency(first);

            caseMap.put(first, firstGraph);
            caseMap.put(second, secondGraph);
        }

        Map<Integer, List<Graph>> counterMap = new TreeMap<>();
        for (Integer index : caseMap.keySet()) {
            Graph graph = caseMap.get(index);
            int size = graph.adjacencyMap.size();
            List<Graph> orDefault = counterMap.getOrDefault(size, new ArrayList<>());
            orDefault.add(graph);
            counterMap.put(size, orDefault);
        }

        // 정답 계산
        int answer = 0;
        for (Integer counter : counterMap.keySet()) {

            List<Graph> graphs = counterMap.get(counter);
            for (Graph currentGraph : graphs) {

                

//                Graph connectedGraph = caseMap.get(currentGraph.adjacencyMap.get(0));
//
//                connectedGraph.adjacencyMap.remove(currentGraph.aIndex);
//                int count = Math.abs(currentGraph.aValue);
//                connectedGraph.aValue += currentGraph.aValue > 0 ? -count : count;
//                answer += count;
            }
        }


//        for (Integer aIndex : caseMap.keySet()) {
//            Graph firstGraph = caseMap.get(aIndex);

//            // 두번째 타겟 찾기
//            Graph secondGraph = null;
//            for (Integer secondIndex : firstGraph.adjacencyList) {
//                Graph tempGraph = caseMap.get(secondIndex);
//                if (tempGraph.aValue != 0) {
//                    secondGraph = tempGraph;
//                    break;
//                }
//            }
//
//            // 첫번째 타겟의 값이 0 이 될 때까지 loop
//            while (secondGraph != null && firstGraph.aValue != 0) {
//                if (firstGraph.aValue > 0) {
//                    firstGraph.aValue--;
//                    secondGraph.aValue++;
//                } else {
//                    firstGraph.aValue++;
//                    secondGraph.aValue--;
//                }
//
//                answer++;
//            }
//        }

        // edges 요소가 0이 아닌데 간선 정보에 있는지 확인, 없다면 -1
        return answer == 0 ? -1 : answer;
    }

}
