package lozm.algorithm;

public class Dijkstra {

    private int nodeNumber;
    private int maps[][];

    public Dijkstra(int nodeNumber) {
        this.nodeNumber = nodeNumber;
        maps = new int[nodeNumber+1][nodeNumber+1];
    }

    public void inputMaps(int x, int y, int weight) {
        maps[x][y] = weight;
        maps[y][x] = weight;
    }

    public void search(int startNodeIndex) {
        int[] distance = new int[nodeNumber+1];
        boolean[] visited = new boolean[nodeNumber+1];

        for (int i = 1; i < distance.length+1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[startNodeIndex] = 0;
        visited[startNodeIndex] = true;

        //연결 노드에 대한 distance 갱신
        for (int i = 1; i < nodeNumber+1; i++) {
            if(!visited[i] && maps[startNodeIndex][i] != 0) {
                distance[i] = maps[startNodeIndex][i];
            }
        }

        for (int index = 0; index < nodeNumber-1; index++) {
            int min = Integer.MIN_VALUE;
            int minIndex = -1;

            //최소값 찾기
            for (int j = 1; j < nodeNumber+1; j++) {
                if(!visited[j] && distance[j] != Integer.MAX_VALUE) {
                    if(distance[j] < min) {
                        min = distance[j];
                        minIndex = j;
                    }
                }
            }

            visited[minIndex] = true;

            //다른 방법과 비교
            for (int j = 1; j < nodeNumber+1; j++) {
                if(!visited[j] && maps[minIndex][j] != 0) {
                    if(distance[j] > distance[minIndex] + maps[minIndex][j]) {
                        distance[j] = distance[minIndex] + maps[minIndex][j];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Dijkstra g = new Dijkstra(8);
        g.inputMaps(1, 2, 3);
        g.inputMaps(1, 5, 4);
        g.inputMaps(1, 4, 4);
        g.inputMaps(2, 3, 2);
        g.inputMaps(3, 4, 1);
        g.inputMaps(4, 5, 2);
        g.inputMaps(5, 6, 4);
        g.inputMaps(4, 7, 6);
        g.inputMaps(7, 6, 3);
        g.inputMaps(3, 8, 3);
        g.inputMaps(6, 8, 2);
        g.search(1);
    }

}
