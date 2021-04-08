package lozm.algorithm;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Permutation {

    private int[] input;
    private int[] output;
    private Set<List<Integer>> result = new LinkedHashSet<>();
    private boolean[] visited;

    protected Permutation() {
    }

    public Permutation(int[] input) {
        this.input = input;
        this.output = new int[input.length];
        this.visited = new boolean[input.length];
    }

    public void run(int n, int r, int choose) {
        if (choose == r) {
            print(output, r);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                output[choose] = input[i];
                run(n, r, choose + 1);
                visited[i] = false;
            }
        }
    }

    private void print(int[] arr, int r) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            list.add(arr[i]);
        }

        result.add(list);
    }
}
