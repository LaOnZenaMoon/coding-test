package lozm.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CompressString {

    @Test
    public void testCase1() {
        // Given
        String s = "aabbaccc";

        // When
        int solution = solution(s);

        // Then
        Assertions.assertEquals(7, solution);
    }

    @Test
    public void testCase2() {
        // Given
        String s = "ababcdcdababcdcd";

        // When
        int solution = solution(s);

        // Then
        Assertions.assertEquals(9, solution);
    }

    @Test
    public void testCase3() {
        // Given
        String s = "abcabcdede";

        // When
        int solution = solution(s);

        // Then
        Assertions.assertEquals(8, solution);
    }

    @Test
    public void testCase4() {
        // Given
        String s = "abcabcabcabcdededededede";

        // When
        int solution = solution(s);

        // Then
        Assertions.assertEquals(14, solution);
    }

    @Test
    public void testCase5() {
        // Given
        String s = "xababcdcdababcdcd";

        // When
        int solution = solution(s);

        // Then
        Assertions.assertEquals(17, solution);
    }

    /**
     * 문자열 압축
     * https://programmers.co.kr/learn/courses/30/lessons/60057
     * <p>
     * 압축할 문자열 s가 매개변수
     * 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return
     */
    public static int bestSolution(String s) {
        int result = s.length();

        for (int group = 1; group <= s.length() / 2; group++) {
            StringBuilder compressedResult = new StringBuilder();
            String currentString = "", previousString = "";
            int equalCount = 1;

            for (int j = 0; j < s.length(); j += group) {
                currentString = s.substring(j, Math.min(j + group, s.length()));

                if (previousString.equals(currentString)) {
                    equalCount++;
                    continue;
                }

                compressedResult.append(equalCount > 1 ? equalCount + previousString : previousString);
                previousString = currentString;
                equalCount = 1;
            }

            compressedResult.append(equalCount > 1 ? equalCount + currentString : currentString);
            result = Math.min(result, compressedResult.length());
        }

        return result;
    }

    public int worstSolution2(String param) {
        TreeMap<Integer, String> map = new TreeMap<>();

        Queue<String> queue = null;
        for (int group = 1; group <= param.length(); group++) {
            queue = new LinkedList<>();

            int cursor = 0;

            while (cursor + group <= param.length()) {
                String substring = param.substring(cursor, cursor + group);
                queue.add(substring);

                cursor++;
                System.out.println("substring = " + substring);
            }

            for (String item : queue) {

            }
            System.out.println("cursor = " + cursor);
        }

        return map.lastKey();
    }

    public int solution(String param) {
        TreeMap<Integer, String> map = new TreeMap<>();

        for (int group = 1; group <= param.length() / 2; group++) {
            int sameStringCount = 1;
            StringBuilder result = new StringBuilder();
            String currentString = "";
            String nextString = "";

            for (int index = 0; index < param.length(); index+=group) {

                currentString = param.substring(index, Math.min(index + group, param.length()));
//                nextString = param.substring();
            }

        }

        return map.lastKey();
    }

}
