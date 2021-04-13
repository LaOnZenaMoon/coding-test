package lozm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

public class DefaultProcessString {

    @Test
    public void testCase1() {
        // Given
        String s = "a234";

        // When
        boolean solution = solution(s);

        // Then
        Assertions.assertEquals(false, solution);
    }

    @Test
    public void testCase2() {
        // Given
        String s = "1234";

        // When
        boolean solution = solution(s);

        // Then
        Assertions.assertEquals(true, solution);
    }

    /**
     * 문자열 다루기 기본
     * https://programmers.co.kr/learn/courses/30/lessons/12918
     * 1. 문자열 s의 길이가 4 혹은 6이고,
     * 2. 숫자로만 구성돼있는지 확인해주는 함수
     */
    public boolean solution(String s) {
        return Pattern.matches("^\\d{4}|\\d{6}$", s);
    }

}
