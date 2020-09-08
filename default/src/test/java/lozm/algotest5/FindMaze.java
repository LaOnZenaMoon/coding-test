package lozm.algotest5;

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

    public static void main(String[] args) {
        printMaze();
        findMazePath(0, 0);
        printMaze();
    }

    private static final int PATH_WAY_COLOR = 0;
    private static final int WALL_COLOR = 1;
    private static final int BLOCKED_COLOR = 2;
    private static final int PATH_COLOR = 3;

    private static boolean findMazePath(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= N) return false;

        if(maze[x][y] != PATH_WAY_COLOR) return false;

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

    private static void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
    }

}
