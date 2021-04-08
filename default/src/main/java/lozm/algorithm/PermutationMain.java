package lozm.algorithm;

import java.util.List;
import java.util.Set;

public class PermutationMain {

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        Permutation permutation = new Permutation(input);
        permutation.run(3, 2, 0);
        Set<List<Integer>> result = permutation.getResult();
        for (List<Integer> integers : result) {
            String s = integers.toString();
            System.out.println("s = " + s);
        }
    }

}
