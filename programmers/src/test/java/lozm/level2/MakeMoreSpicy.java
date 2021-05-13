package lozm.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MakeMoreSpicy {

    @Test
    public void testCase1() {
        // Given
        int[] scroville = {1, 2, 3, 9, 10, 12};
        int k = 7;

        // When
        final int solution = solution(scroville, k);

        // Then
        Assertions.assertEquals(2, solution);
    }

    /**
     * 더 맵게
     * https://programmers.co.kr/learn/courses/30/lessons/42626
     *
     * Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville
     * 원하는 스코빌 지수 K가 주어질 때,
     * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return
     *
     * 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return
     *
     * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
     */
    public int solution(int[] scovilleArray, int minimumScoville) {
        if (scovilleArray.length == 0) {
            return -1;
        }

        Queue<Integer> queue = new PriorityQueue<>();
        for (int item : scovilleArray) {
            queue.add(item);
        }

        int answer = 0;

        while (queue.size() > 1) {
            final Integer firstItem = queue.poll();
            final Integer secondItem = queue.poll();

            answer++;
            final int mixedItem = firstItem + (secondItem * 2);
            queue.add(mixedItem);

            if (isEnd(minimumScoville, queue)) {
                break;
            }
        }

        if (queue.size() == 1 && queue.peek() < minimumScoville) {
            return -1;
        }

        return answer;
    }

    private boolean isEnd(int minimum, Queue<Integer> queue) {
        boolean end = true;

        final Iterator<Integer> queueIterator = queue.iterator();
        while (queueIterator.hasNext()) {
            final Integer item = queueIterator.next();
            if (item < minimum) {
                end = false;
                break;
            }
        }

        return end;
    }

}
