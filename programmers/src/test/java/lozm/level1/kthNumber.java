package lozm.level1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kthNumber {

    @Test
    void test() {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] solution = solution(array, commands);

        Assertions.assertEquals(3, solution.length);
        Assertions.assertEquals(5, solution[0]);
        Assertions.assertEquals(6, solution[1]);
        Assertions.assertEquals(3, solution[2]);
    }

    /**
     * commands: array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수
     */
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> resultList = new ArrayList<>();

        int caseLength = commands.length;
        for (int i = 0; i < caseLength; i++) {
            int[] command = commands[i];
            int startIndex = command[0] - 1;
            int endIndex = command[1];
            int kth = command[2] - 1;

            int[] copiedArray = Arrays.copyOfRange(array, startIndex, endIndex);
            Arrays.sort(copiedArray);

            int kthNumber = copiedArray[kth];
            resultList.add(kthNumber);
        }

        return resultList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
