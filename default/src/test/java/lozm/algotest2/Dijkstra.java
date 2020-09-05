package lozm.algotest2;

public class Dijkstra {

    public static void main(String[] args) {
        Dijkstra g = new Dijkstra(8);
        g.inputMaps(0, 1, 3);
        g.inputMaps(0, 4, 4);
        g.inputMaps(0, 3, 4);
        g.inputMaps(1, 2, 2);
        g.inputMaps(2, 3, 1);
        g.inputMaps(3, 4, 2);
        g.inputMaps(4, 5, 4);
        g.inputMaps(3, 6, 6);
        g.inputMaps(6, 5, 3);
        g.inputMaps(2, 7, 3);
        g.inputMaps(5, 7, 2);

        g.search(0);
    }

    private void search(int start) {
        boolean[] visited = new boolean[nodeNumber];
        int[] distance = new int[nodeNumber];

        for (int i = 0; i < nodeNumber; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        visited[start] = true;
        distance[start] = 0;

        for (int i = 0; i < nodeNumber; i++) {
            if(!visited[i] && maps[start][i] != 0) {
                distance[i] = maps[start][i];
            }
        }

        for (int i = 0; i < nodeNumber-1; i++) {
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;

            for (int j = 0; j < nodeNumber; j++) {
                if(!visited[j] && distance[j] != Integer.MAX_VALUE) {
                    minIndex = j;
                    minValue = distance[j];
                }
            }

            visited[minIndex] = true;

            for (int j = 0; j < nodeNumber; j++) {
                if(!visited[j] && maps[minIndex][j] != 0) {
                    if(distance[j] > distance[minIndex] + maps[minIndex][j]) {
                        distance[j] = distance[minIndex] + maps[minIndex][j];
                    }
                }
            }

        }

        for (int j = 0; j < nodeNumber; j++) {
            System.out.print(distance[j] + " ");
        }
        System.out.println();

    }

    private void inputMaps(int x, int y, int weight) {
        this.maps[x][y] = weight;
        this.maps[y][x] = weight;
    }

    private int nodeNumber;
    private int[][] maps;

    public Dijkstra(int nodeNumber) {
        this.nodeNumber = nodeNumber;
        this.maps = new int[nodeNumber][nodeNumber];
    }

}
