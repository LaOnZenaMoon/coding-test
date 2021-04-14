package lozm.level1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CaesarPassword {

    @Test
    public void testCase1() {
        // Given
        String s = "AB";
        int n = 1;

        // When
        String solution = solution(s, n);

        // Then
        Assertions.assertEquals("BC", solution);
    }

    @Test
    public void testCase2() {
        // Given
        String s = "z";
        int n = 1;

        // When
        String solution = solution(s, n);

        // Then
        Assertions.assertEquals("a", solution);
    }

    @Test
    public void testCase3() {
        // Given
        String s = "a B z";
        int n = 4;

        // When
        String solution = solution(s, n);

        // Then
        Assertions.assertEquals("e F d", solution);
    }

    /**
     * 시저 암호
     * https://programmers.co.kr/learn/courses/30/lessons/12926
     */
    public String solution(String s, int n) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            int target = s.charAt(i);
            if (97 <= target && target <= 122) {
                target += n;
                target = target > 122 ? target - 26 : target;
            } else if (65 <= target && target <= 90) {
                target += n;
                target = target > 90 ? target - 26 : target;
            }

            answer += (char) target;
        }

        return answer;
    }

}
