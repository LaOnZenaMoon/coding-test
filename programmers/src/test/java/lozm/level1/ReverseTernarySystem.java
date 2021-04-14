package lozm.level1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseTernarySystem {

    @Test
    void testCase1() {
        // Given
        int n = 45;

        // When
        int solution = solution(n);

        // Then
        Assertions.assertEquals(7, solution);
    }

    @Test
    void testCase2() {
        // Given
        int n = 125;

        // When
        int solution = solution(n);

        // Then
        Assertions.assertEquals(229, solution);
    }

    /**
     * 자연수 n이 매개변수로 주어집니다.
     * n을 3진법 상에서 앞뒤로 뒤집은 후,
     * 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
     */
    public int solution(int n) {
        // 1. 3진법으로 만들기
        String ternaryValue = toDeposition(n, 3);

        // 2. 3진법 뒤집기
        String reversedTernaryValue = new StringBuilder(ternaryValue).reverse().toString();

        // 3. 10진법으로 만들기
        return Integer.valueOf(reversedTernaryValue, 3);
    }

    private String toDeposition(int value, int i) {
        String returnString = "";

        while (value != 0) {
            if ((value % i) < 10) {
                returnString = (value % i) + returnString;
                value /= i;
            } else {
                int temp1 = (char) ((value % i) + 55);
                returnString = Integer.toString(temp1) + returnString;
            }
        }
        return returnString;
    }

    public int bestSolution(int n) {
        String a = "";

        while (n > 0) {
            a = (n % 3) + a;
            n /= 3;
        }
        a = new StringBuilder(a).reverse().toString();


        return Integer.parseInt(a, 3);
    }

}
