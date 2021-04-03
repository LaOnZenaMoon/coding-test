package lozm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetMiddleLetter {

    @Test
    void testCase1() {
        // Given
        String s = "abcde";

        // When
        String solution = solution(s);

        // Then
        Assertions.assertEquals("c", solution);
    }

    @Test
    void testCase2() {
        // Given
        String s = "qwer";

        // When
        String solution = solution(s);

        // Then
        Assertions.assertEquals("we", solution);
    }

    public String solution(String s) {
        int length = s.length();

        if (length % 2 == 0) {
            // 1. 짝수일 때
            return s.substring(length / 2 - 1, length / 2 + 1);
        } else {
            // 2. 홀수일 때
            return s.substring(length / 2, length / 2 + 1);
        }
    }

    public String bestSolution(String word) {
        return word.substring((word.length()-1) / 2, word.length()/2 + 1);
    }

}
