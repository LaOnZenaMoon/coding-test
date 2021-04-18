package lozm.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Printer {

    @Test
    public void testCase1() {
        // Given
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        // When
        int solution = solution(priorities, location);

        // Then
        Assertions.assertEquals(1, solution);
    }

    @Test
    public void testCase2() {
        // Given
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        // When
        int solution = solution(priorities, location);

        // Then
        Assertions.assertEquals(5, solution);
    }

    /**
     * 프린터
     * https://programmers.co.kr/learn/courses/30/lessons/42587
     *
     * 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
     * 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
     * 3. 그렇지 않으면 J를 인쇄합니다.
     * <p>
     * 현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities
     * 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location
     * 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return
     */
    public int solution(int[] priorities, int location) {

        Queue<PrintItem> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new PrintItem(priorities[i], location == i ? true : false));
        }

        int answer = 1;
        while (!queue.isEmpty()) {
            PrintItem source = queue.poll();

            boolean sourceIsHighestPriority = true;
            for (PrintItem target : queue) {
                if (source.priority < target.priority) {
                    queue.add(source);
                    sourceIsHighestPriority = false;
                    break;
                }
            }

            if (source.isMine && sourceIsHighestPriority) {
                break;
            }

            if (sourceIsHighestPriority) {
                answer++;
            }
        }

        return answer;
    }

    class PrintItem {
        int priority;
        boolean isMine;

        public PrintItem(int priority, boolean isMine) {
            this.priority = priority;
            this.isMine = isMine;
        }
    }

}
