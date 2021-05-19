package lozm.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class DoublePriorityQueue {

    @Test
    public void testCase1() {
        // Given
        String[] operations = {"I 16","D 1"};

        // When
        final int[] solution = solution(operations);

        // Then
        int[] result = {0,0};
        Assertions.assertArrayEquals(result, solution);
    }

    @Test
    public void testCase2() {
        // Given
        String[] operations = {"I 7","I 5","I -5","D -1"};

        // When
        final int[] solution = solution(operations);

        // Then
        int[] result = {7,5};
        Assertions.assertArrayEquals(result, solution);
    }

    /**
     * 이중우선순위큐
     * https://programmers.co.kr/learn/courses/30/lessons/42628
     *
     * 명령어	수신 탑(높이)
     * I 숫자	큐에 주어진 숫자를 삽입합니다.
     * D 1	큐에서 최댓값을 삭제합니다.
     * D -1	큐에서 최솟값을 삭제합니다.
     *
     * 1. 이중 우선순위 큐가 할 연산 operations가 매개변수
     * 2. 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return
     */
    public int[] solution(String[] operations) {
        final String INSERT = "I ";
        final String DELETE_MAX = "D 1";
        final String DELETE_MIN = "D -1";

        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(((o1, o2) -> o2 >= o1 ? 1 : -1));

        for (String operation : operations) {
            if (operation.contains(INSERT)) {
                final int intValue = getIntValue(INSERT, operation);
                minQueue.add(intValue);
                maxQueue.add(intValue);
            } else if (operation.contains(DELETE_MAX) && !maxQueue.isEmpty()) {
                final Integer max = maxQueue.poll();
                minQueue.remove(max);
            } else if (operation.contains(DELETE_MIN) && !minQueue.isEmpty()) {
                final Integer min = minQueue.poll();
                maxQueue.remove(min);
            }
        }

        if (minQueue.isEmpty() && maxQueue.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{maxQueue.poll(), minQueue.poll()};
    }

    private int getIntValue(String INSERT, String operation) {
        final String value = operation.split(INSERT)[1];
        final int intValue = Integer.parseInt(value);
        return intValue;
    }

}
