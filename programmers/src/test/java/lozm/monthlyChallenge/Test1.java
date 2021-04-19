package lozm.monthlyChallenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test1 {

    /**
     * [4,7,12]	[true,false,true]	9
     * [1,2,3]	[false,false,true]	0
     */

    @Test
    public void testCase1() {
        // Given
        int[] absolutes = {4,7,12};
        boolean[] signs = {true,false,true};

        // When
        int solution = solution(absolutes, signs);

        // Then
        Assertions.assertEquals(9, solution);
    }

    @Test
    public void testCase2() {
        // Given
        int[] absolutes = {1,2,3};
        boolean[] signs = {false,false,true};

        // When
        int solution = solution(absolutes, signs);

        // Then
        Assertions.assertEquals(0, solution);
    }

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }

}
