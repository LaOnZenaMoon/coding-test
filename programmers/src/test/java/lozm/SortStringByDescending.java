package lozm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class SortStringByDescending {

    @Test
    public void testCase1() {
        // Given
        String s = "Zbcdefg";

        // When
        String solution = solution(s);

        // Then
        Assertions.assertEquals("gfedcbZ", solution);
    }

    public String solution(String s) {
        return Arrays.stream(s.split(""))
                .sorted(Collections.reverseOrder())
                .collect(Collectors.joining(""));
    }

}
