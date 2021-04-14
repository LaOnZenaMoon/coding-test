package lozm.level1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

public class ArrangeYourOwnStrings {

    @Test
    public void testCase1() {
        // Given
        String[] strings = {"sun", "bed", "car"};
        int n = 1;

        // When
        String[] solution = bestSolution(strings, n);

        // Then
        String[] answers = {"car", "bed", "sun"};
        Assertions.assertArrayEquals(answers, solution);
    }

    @Test
    public void testCase2() {
        // Given
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;

        // When
        String[] solution = bestSolution(strings, n);

        // Then
        String[] answers = {"abcd", "abce", "cdx"};
        Assertions.assertArrayEquals(answers, solution);
    }

    /**
     * 1. 문자열로 구성된 리스트 strings
     * 2. 정수 n이 주어졌을 때
     * 3. 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
     * 4. 인덱스의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
     */
    public String[] solution(String[] strings, int n) {
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length - i - 1; j++) {
                String source = strings[j];
                char sourceChar = source.charAt(n);
                String target = strings[j + 1];
                char targetChar = target.charAt(n);

                if (sourceChar > targetChar) {
                    // Swap
                    String temp = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = temp;
                } else if (sourceChar == targetChar && source.compareTo(target) > 0) {
                    // Swap
                    String temp = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = temp;
                }
            }
        }

        return strings;
    }

    public String[] bestSolution(String[] strings, int n) {
        String[] answer = {};
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            arr.add("" + strings[i].charAt(n) + strings[i]);
        }
        Collections.sort(arr);
        answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).substring(1, arr.get(i).length());
        }
        return answer;
    }

}
