package lozm.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class StockPrice {

    @Test
    void testCase1() {
        //Given
        int[] prices = {1, 2, 3, 2, 3};

        //When
        int[] solution = solution(prices);

        //Then
        int[] answer = {4, 3, 1, 1, 0};
        Assertions.assertArrayEquals(answer, solution);
    }

    /**
     * 주식가격
     * https://programmers.co.kr/learn/courses/30/lessons/42584
     *
     * 초 단위로 기록된 주식가격이 담긴 배열 prices
     * 가격이 떨어지지 않은 기간은 몇 초인지를 return
     */
    public int[] solution(int[] prices) {

        Queue<Integer> queue = new LinkedList<>();
        for (int price : prices) {
            queue.add(price);
        }

        List<Integer> answerList = new ArrayList<>();

        while (!queue.isEmpty()) {
            int time = 0;
            Integer source = queue.poll().intValue();

            if (queue.isEmpty()) {
                answerList.add(time);
                break;
            }

            int compareCount = 0;
            while (compareCount++ < queue.size()) {
                Integer target = queue.poll();
                queue.add(target);

                time++;

                if (source > target) {
                    break;
                }
            }

            answerList.add(time);
        }

        return answerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int[] solution1(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length - 1; i++) {
            int time = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    time = j - i;
                    break;
                } else if (prices[i] > prices[j]) {
                    time = 1;
                }
            }
            answer[i] = time;
        }

        return answer;
    }

    public int[] solution2(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<int[]> stack = new Stack<>();

        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] > prices[i + 1]) {
                answer[i] = 1;
                stack.push(new int[]{prices[i + 1], i + 1});
            } else {
                // 스택에서 자신보다 낮은 값이 나올때까지 모두 지워줌
                while (stack.size() > 0 && stack.peek()[0] >= prices[i]) {
                    stack.pop();
                }
                // 스택이 빌 경우 (뒷쪽의 모든 값이 자신보다 큼)
                if (stack.size() == 0) {
                    answer[i] = prices.length - i - 1;

                    // 스택에 자신보다 낮은 숫자가 남아있다면 해당 인덱스와 자신의 인덱스를 이용해 계산
                } else {
                    answer[i] = stack.peek()[1] - i;
                }
            }
        }

        return answer;
    }

}
