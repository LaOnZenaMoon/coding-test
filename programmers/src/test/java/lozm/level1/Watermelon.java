package lozm.level1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Watermelon {

    @Test
    public void testCase1() {
        // Given
        int n = 3;

        // When
        String solution = solution(n);

        // Then
        Assertions.assertEquals("수박수", solution);
    }

    @Test
    public void testCase2() {
        // Given
        int n = 4;

        // When
        String solution = solution(n);

        // Then
        Assertions.assertEquals("수박수박", solution);
    }

    /**
     * 수박수박수박수박수박수?
     * https://programmers.co.kr/learn/courses/30/lessons/12922
     * 1. 길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수
     */
    public String solution(int n) {
        String answer = "";
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                answer += "박";
            } else {
                answer += "수";
            }
        }
        return answer;
    }

}
