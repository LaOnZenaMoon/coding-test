package lozm.algorithm;

import java.util.List;
import java.util.Set;

public class PermutationMain {

    public static void main(String[] args) {
        Integer[] input = {1, 2, 3};
        Permutation<Integer> permutation = new Permutation(input, new Integer[input.length]);
        permutation.run(3, 2, 0);
        Set<List<Integer>> result = permutation.getResult();
        for (List<Integer> integers : result) {
            String s = integers.toString();
            System.out.println("s = " + s);
        }
    }

}
