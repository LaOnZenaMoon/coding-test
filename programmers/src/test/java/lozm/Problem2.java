package lozm;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Problem2 {

    @Test
    void mainTest() {

    makeCal(4);
//        solution(s, c);
    }




    public int[] solution(int day, int k) {
        int[] answer = new int[12];

        int[] weekendType1 = {0, 1, 2, 3, 4, 5, 6};
        int[] weekendType2 = {6, 0, 1, 2, 3, 4, 5};
        int[] weekendType3 = {5, 6, 0, 1, 2, 3, 4};
        int[] weekendType4 = {4, 5, 6, 0, 1, 2, 3};
        int[] weekendType5 = {3, 4, 5, 6, 0, 1, 2};
        int[] weekendType6 = {2, 3, 4, 5, 6, 0, 1};
        int[] weekendType7 = {1, 2, 3, 4, 5, 6, 0};

        int[] monthDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int[] weekend = new int[7];
        for (int i = 1; i < 8 ; i++) {

        }


        return answer;
    }

    public int[] makeCal(int day) {
        int[] cal = new int[365];

        int[] weekendType1 = {0, 1, 2, 3, 4, 5, 6};
        int[] weekendType2 = {6, 0, 1, 2, 3, 4, 5};
        int[] weekendType3 = {5, 6, 0, 1, 2, 3, 4};
        int[] weekendType4 = {4, 5, 6, 0, 1, 2, 3};
        int[] weekendType5 = {3, 4, 5, 6, 0, 1, 2};
        int[] weekendType6 = {2, 3, 4, 5, 6, 0, 1};
        int[] weekendType7 = {1, 2, 3, 4, 5, 6, 0};

        for (int i = 0; i < 365; i++) {
            System.out.println("i = " + i);
        }

        return cal;
    }

}
