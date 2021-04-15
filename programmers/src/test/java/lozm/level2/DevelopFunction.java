package lozm.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class DevelopFunction {

    @Test
    public void testCase1() {
        // Given
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        // When
        int[] solution = solution(progresses, speeds);

        // Then
        int[] answer = {2, 1};
        Assertions.assertArrayEquals(answer, solution);
    }

    @Test
    public void testCase2() {
        // Given
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        // When
        int[] solution = solution(progresses, speeds);

        // Then
        int[] answer = {1, 3, 2};
        Assertions.assertArrayEquals(answer, solution);
    }

    /**
     * 기능개발
     * https://programmers.co.kr/learn/courses/30/lessons/42586
     *
     * 1. 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses
     * 2. 각 작업의 개발 속도가 적힌 정수 배열 speeds
     * 3. 각 배포마다 몇 개의 기능이 배포되는지를 return
     */
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        LinkedList<Function> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add(new Function(progresses[i], speeds[i]));
        }

        while (!queue.isEmpty()) {
            int completedFunctionNumber = 0;
            while (!queue.isEmpty() && queue.peek().progress >= 100) {
                queue.poll();
                completedFunctionNumber++;
            }

            if (completedFunctionNumber > 0) {
                answer.add(completedFunctionNumber);
            }

            for (Function function : queue) {
                function.progress += function.speeds;
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    class Function {
        int progress;
        int speeds;

        public Function(int progress, int speeds) {
            this.progress = progress;
            this.speeds = speeds;
        }
    }

}
