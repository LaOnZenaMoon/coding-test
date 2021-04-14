package lozm.algorithm;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Permutation<T> {

    private T[] input;
    private T[] output;
    private Set<List<T>> result = new LinkedHashSet<>();
    private boolean[] visited;

    protected Permutation() {
    }

    public Permutation(T[] input, T[] output) {
        this.input = input;
        this.output = output;
        this.visited = new boolean[input.length];
    }

    public Set<List<T>> getResult() {
        return result;
    }

    public void run(int n, int r, int choose) {
        if (choose == r) {
            addResult(output, r);
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

    private void addResult(T[] output, int r) {
        List<T> elementList = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            elementList.add(output[i]);
        }

        result.add(elementList);
    }
}
