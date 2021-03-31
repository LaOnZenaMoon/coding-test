package lozm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class Year2016 {

    @Test
    void testCase1() {
        // Given
        int a = 5;
        int b = 24;

        // When
        String solution = solution(a, b);

        // Then
        Assertions.assertEquals("TUE", solution);
    }

    public String solution(int a, int b) {
        return LocalDate.of(2016, a, b)
                .getDayOfWeek()
                .name()
                .substring(0, 3);
    }

}
