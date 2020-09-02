package lozm.algorithm;

public class Dijkstra {

    private int nodeNumber;
    private int maps[][];

    public Dijkstra(int nodeNumber) {
        this.nodeNumber = nodeNumber;
        maps = new int[nodeNumber][nodeNumber];
    }

    public void inputMaps(int x, int y, int weight) {
        maps[x][y] = weight;
        maps[y][x] = weight;
    }

    public void search(int startNodeIndex) {
        int[] distance = new int[nodeNumber];
        boolean[] visited = new boolean[nodeNumber];

        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[startNodeIndex] = 0;
        visited[startNodeIndex] = true;

        //연결 노드에 대한 distance 갱신
        for (int i = 0; i < nodeNumber; i++) {
            if(!visited[i] && maps[startNodeIndex][i] != 0) {
                distance[i] = maps[startNodeIndex][i];
            }
        }

        for (int i = 0; i < nodeNumber-1; i++) {
            int min = Integer.MIN_VALUE;
            int minIndex = -1;

            //최소값 찾기
            for (int j = 0; j < nodeNumber; j++) {
                if(!visited[j] && distance[j] != Integer.MAX_VALUE) {
                    if(distance[j] < min) {
                        min = distance[j];
                        minIndex = j;
                    }
                }
            }

            visited[minIndex] = true;

            //다른 방법과 비교
            for (int j = 0; j < nodeNumber; j++) {
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
        g.inputMaps(0, 1, 3);
        g.inputMaps(0, 4, 4);
        g.inputMaps(0, 3, 4);
        g.inputMaps(1, 3, 2);
        g.inputMaps(2, 3, 1);
        g.inputMaps(3, 4, 2);
        g.inputMaps(4, 5, 4);
        g.inputMaps(3, 6, 6);
        g.inputMaps(6, 5, 3);
        g.inputMaps(2, 7, 3);
        g.inputMaps(5, 7, 2);
        g.search(1);
    }

}
