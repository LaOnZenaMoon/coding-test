package lozm.level1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Pocketmon {

    @Test
    public void testCase1() {
        // Given
        int[] nums = {3, 1, 2, 3};

        // When
        int solution = solution(nums);

        // Then
        Assertions.assertEquals(2, solution);
    }

    @Test
    public void testCase2() {
        // Given
        int[] nums = {3, 3, 3, 2, 2, 4};

        // When
        int solution = solution(nums);

        // Then
        Assertions.assertEquals(3, solution);
    }

    @Test
    public void testCase3() {
        // Given
        int[] nums = {3, 3, 3, 2, 2, 2};

        // When
        int solution = solution(nums);

        // Then
        Assertions.assertEquals(2, solution);
    }

    public int solution(int[] nums) {
        Combination combination = new Combination(nums);
        combination.run(nums.length, nums.length / 2, 0);
        Set<List<Integer>> result = combination.getResult();

        int answer = 0;
        for (List<Integer> integers : result) {
            Set<Integer> numOfElements = new HashSet<>();
            for (Integer integer : integers) {
                numOfElements.add(integer);
            }

            if (answer < numOfElements.size()) {
                answer = numOfElements.size();
            }
        }

        return answer;
    }

    class Combination {

        private int[] input;
        private Set<List<Integer>> result = new LinkedHashSet<>();
        private boolean[] visited;

        protected Combination() {
        }

        public Combination(int[] input) {
            this.input = input;
            this.visited = new boolean[input.length];
        }

        public Set<List<Integer>> getResult() {
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
            List<Integer> elementList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    elementList.add(input[i]);
                }
            }

            result.add(elementList);
        }

    }

}
