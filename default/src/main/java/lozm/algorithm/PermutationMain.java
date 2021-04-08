package lozm.algorithm;

public class PermutationMain {

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        Permutation permutation = new Permutation(input);
        permutation.run(3, 2, 0);

        System.out.println("permutation = " + permutation);
    }

}
