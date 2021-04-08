package lozm.algorithm;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Combination {

    private int[] input;
    private Set<List<Integer>> result = new LinkedHashSet<>();
    private boolean[] visited;

    protected Combination() {
    }

    public Combination(int[] input) {
        this.input = input;
        this.visited = new boolean[input.length];
    }

    public Set<List<Integer>> getResult() {
        return result;
    }

    public void run(int n, int r, int choose) {
        if (r == 0) {
            addResult(visited, n);
            return;
        }

        for (int i = choose; i < n; i++) {
            visited[i] = true;
            run(n, r - 1, i + 1);
            visited[i] = false;
        }
    }

    private void addResult(boolean[] visited, int n) {
        List<Integer> elementList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                elementList.add(input[i]);
            }
        }

        result.add(elementList);
    }

}
