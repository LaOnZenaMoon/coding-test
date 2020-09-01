package lozm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test10974 {

    /**
     * 문제
     * N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.
     *
     * 입력
     * 첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.
     *
     * 출력
     * 첫째 줄부터 N!개의 줄에 걸쳐서 모든 순열을 사전순으로 출력한다.
     */

    static List<Integer> targetList = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        boolean[] targetCheckArray = new boolean[number + 1];

        solution(number, targetCheckArray);
    }

    private static void solution(int number, boolean[] targetCheckArray) {

    }

}
