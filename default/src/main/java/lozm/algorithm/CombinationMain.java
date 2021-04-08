package lozm.algorithm;

import java.util.List;
import java.util.Set;

public class CombinationMain {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        Combination combination = new Combination(input);
        combination.run(4, 2, 0);
        Set<List<Integer>> result = combination.getResult();
        for (List<Integer> integers : result) {
            String s = integers.toString();
            System.out.println("s = " + s);
        }
    }

}
