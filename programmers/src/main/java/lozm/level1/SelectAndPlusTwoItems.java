package lozm.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SelectAndPlusTwoItems {

    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 4, 1};
//        int[] numbers = {5, 0, 2, 7};

//        int[] solution = solution(numbers);
        int[] solution = solutionBestCase(numbers);
        System.out.println("solution = " + solution);
    }

    /**
     * 1. 배열에 서로 다른 인덱스에 있는 두 수를 더하여 만들 수 있는 모든 케이스 만들기
     * numbers의 길이는 2 이상 100 이하입니다.
     * numbers의 모든 수는 0 이상 100 이하입니다.
     * <p>
     * 두 수를 더한 결과를 담을 자료구조(중복X, 순서X/O)
     * <p>
     * 2. 오름차순 정렬
     */

    public static int[] solution(int[] numbers) {
        Set<Integer> plusResultSet = new HashSet<Integer>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int plusResult = numbers[i] + numbers[j];
                plusResultSet.add(plusResult);
            }
        }

        Integer[] toArray = plusResultSet.toArray(new Integer[plusResultSet.size()]);
        Arrays.sort(toArray);

        return Arrays.stream(toArray)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static int[] solutionBestCase(int[] numbers) {
        Set<Integer> plusResultSet = new TreeSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int plusResult = numbers[i] + numbers[j];
                plusResultSet.add(plusResult);
            }
        }

        Integer[] toArray = plusResultSet.toArray(new Integer[plusResultSet.size()]);
        return Arrays.stream(toArray)
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
