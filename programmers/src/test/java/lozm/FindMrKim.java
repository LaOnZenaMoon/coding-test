package lozm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FindMrKim {

    @Test
    public void testCase1() {
        // Given
        String[] seoul = {"Jane", "Kim"};

        // When
        String solution = solution(seoul);

        // Then
        Assertions.assertEquals("김서방은 1에 있다", solution);
    }

    /**
     * 서울에서 김서방 찾기
     * https://programmers.co.kr/learn/courses/30/lessons/12919
     * 1. String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아,
     * 2. "김서방은 x에 있다"는 String을 반환하는 함수, solution
     * 3. seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.
     */
    public String solution(String[] seoul) {
        int location = 0;
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                location = i;
                break;
            }
        }

        return String.format("김서방은 %d에 있다", location);
    }

    public String bestSolution(String[] seoul) {
        return String.format("김서방은 %d에 있다", Arrays.asList(seoul).indexOf("Kim"));
    }

}
