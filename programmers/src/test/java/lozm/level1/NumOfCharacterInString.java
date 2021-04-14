package lozm.level1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumOfCharacterInString {

    @Test
    public void testCase1() {
        // Given
        String s = "pPoooyY";

        // When
        boolean solution = solution(s);

        // Then
        Assertions.assertEquals(true, solution);
    }

    @Test
    public void testCase2() {
        // Given
        String s = "Pyy";

        // When
        boolean solution = solution(s);

        // Then
        Assertions.assertEquals(false, solution);
    }

    /**
     * 1. 대문자와 소문자가 섞여있는 문자열 s가 주어집니다.
     * 2. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return
     * 3. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다.
     * 4. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
     */
    boolean solution(String s) {
        String lowerCasedString = s.toLowerCase();
        int numOfP = 0;
        int numOfY = 0;

        for (int i = 0; i < lowerCasedString.length(); i++) {
            char c = lowerCasedString.charAt(i);

            if (c == 'y') {
                numOfY++;
            } else if(c == 'p') {
                numOfP++;
            }
        }

        boolean answer = true;
        if (numOfP != numOfY) {
            answer = false;
        }

        return answer;
    }

    boolean bestSolution(String s) {
        s = s.toUpperCase();

        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
    }

}
