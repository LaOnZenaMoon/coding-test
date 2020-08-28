package lozm;

public class FindMaze {

    private static int N = 8;
    private static int[][] maze = {
        {0, 0, 0, 0, 0, 0, 0, 1},
        {0, 1, 1, 0, 1, 1, 0, 1},
        {0, 0, 0, 1, 0, 0, 0, 1},
        {0, 1, 0, 0, 1, 1, 0, 0},
        {0, 1, 1, 1, 0, 0, 1, 1},
        {0, 1, 0, 0, 0, 1, 0, 1},
        {0, 0, 0, 1, 0, 0, 0, 1},
        {0, 1, 1, 1, 0, 1, 0, 0}
    };

    private static final int PATHWAY_COLOR = 0;
    private static final int WALL_COLOR = 1;
    private static final int BLOCKED_COLOR = 2;
    private static final int PATH_COLOR = 3;

    /**
     * 현재 위치에서 출구까지 가는 경로가 있으려면
     * 1) 현재 위치가 출구이거나
     * 2) 이웃한 셀들 중 하나에서 현재 위치를 지나지 않고 출구까지 가는 경로가 있거나
     * @param x
     * @param y
     * @return
     */

    public static boolean findMazePath(int x, int y) {
        if(x < 0 || y <0 || x >= N || y >= N) return false;

        if(maze[x][y] != PATHWAY_COLOR) return false;

        if(x == N-1 && y == N-1) {
            maze[x][y] = PATH_COLOR;
            return true;
        } else {
            maze[x][y] = PATH_COLOR;

            if(
                    findMazePath(x, y-1) || findMazePath(x+1, y) ||
                    findMazePath(x, y+1) || findMazePath(x-1, y)
            ) {
                return true;
            }

            maze[x][y] = BLOCKED_COLOR;
            return false;
        }
    }

    public static void main(String[] args) {
        printMaze();
        findMazePath(0, 0);
        printMaze();
    }

    private static void printMaze() {
        System.out.println("=============================");
        for (int i = 0; i < maze.length ; i++) {
            for (int j = 0; j < maze[i].length ; j++) {
                System.out.print("["+maze[i][j]+"]");
            }
            System.out.println();
        }
    }


}
