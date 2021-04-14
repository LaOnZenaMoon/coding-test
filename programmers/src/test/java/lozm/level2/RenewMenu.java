package lozm.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class RenewMenu {

    @Test
    public void testCase1() {
        // Given
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        // When
        String[] solution = solution(orders, course);

        // Then
        String[] answer = {"AC", "ACDE", "BCFG", "CDE"};
        Assertions.assertArrayEquals(answer, solution);
    }

    @Test
    public void testCase2() {
        // Given
        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2, 3, 5};

        // When
        String[] solution = solution(orders, course);

        // Then
        String[] answer = {"ACD", "AD", "ADE", "CD", "XYZ"};
        Assertions.assertArrayEquals(answer, solution);
    }

    @Test
    public void testCase3() {
        // Given
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};

        // When
        String[] solution = solution(orders, course);

        // Then
        String[] answer = {"WX", "XY"};
        Assertions.assertArrayEquals(answer, solution);
    }

    /**
     * 메뉴 리뉴얼
     * https://programmers.co.kr/learn/courses/30/lessons/72411
     *
     * <p>
     * 1. 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성하려고 합니다
     * 2. 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함
     * 3. 각 손님은 단품메뉴를 2개 이상 주문해야 하며, 각 단품메뉴는 A ~ Z의 알파벳 대문자로 표기합니다.
     * <p>
     * 각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열 orders
     * "스카피"가 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열 course
     * 새로 추가하게 될 코스요리의 메뉴 구성을 문자열 형태로 배열에 담아 return
     * <p>
     * 정답은 각 코스요리 메뉴의 구성을 문자열 형식으로 배열에 담아 사전 순으로 오름차순 정렬해서 return
     * 만약 가장 많이 함께 주문된 메뉴 구성이 여러 개라면, 모두 배열에 담아 return 하면 됩니다.
     */
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        for (int selection : course) {
            Map<String, Integer> caseCountMap = new HashMap<>();

            for (String order : orders) {
                String[] orderArray = order.split("");
                Arrays.sort(orderArray);

                Combination combination = new Combination(orderArray);
                combination.run(orderArray.length, selection, 0);

                Set<List<String>> result = combination.getResult();
                for (List<String> strings : result) {
                    String source = String.join("", strings);
                    int addCount = caseCountMap.containsKey(source) ? caseCountMap.get(source) + 1 : 1;
                    caseCountMap.put(source, addCount);
                }
            }

            int max = 0;
            for (String key : caseCountMap.keySet()) {
                Integer count = caseCountMap.get(key);
                if (count > max) {
                    max = count;
                }
            }

            if (max < 2) {
                continue;
            }

            for (String key : caseCountMap.keySet()) {
                Integer count = caseCountMap.get(key);
                if (count == max) {
                    answer.add(key);
                }
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }

    class Combination {

        private String[] input;
        private Set<List<String>> result = new LinkedHashSet<>();
        private boolean[] visited;

        protected Combination() {
        }

        public Combination(String[] input) {
            this.input = input;
            this.visited = new boolean[input.length];
        }

        public Set<List<String>> getResult() {
            return result;
        }

        public void run(int n, int r, int choose) {
            if (r == 0) {
                addResult(visited, n);
                return;
            }

            for (int i = choose; i < n; i++) {
                visited[i] = true;
                run(n, r - 1, i + 1);
                visited[i] = false;
            }
        }

        private void addResult(boolean[] visited, int n) {
            List<String> elementList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    elementList.add(input[i]);
                }
            }

            result.add(elementList);
        }
    }

}
