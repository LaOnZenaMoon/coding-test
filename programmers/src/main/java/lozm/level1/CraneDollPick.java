package lozm.level1;

import java.util.Stack;

public class CraneDollPick {

    public static void main(String[] args) {
        // Given
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        // When
        int solution = solution(board, moves);

        // Then
        System.out.println("solution = " + solution);
    }

    /**
     * board 배열은 2차원 배열로 크기는 "5 x 5" 이상 "30 x 30" 이하입니다.
     * board의 각 칸에는 0 이상 100 이하인 정수가 담겨있습니다.
     * 0은 빈 칸을 나타냅니다.
     * 1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타냅니다.
     * moves 배열의 크기는 1 이상 1,000 이하입니다.
     * moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수입니다.
     */

    /**
     * 1. board 이차원 배열 행에서 숫자 하나를 뽑아서 moves 에 넣는다.
     * 2. moves 에 동일한 숫자가 넣어질 경우, 동일한 숫자는 없어진다.
     * 3. 없어진 숫자의 갯수를 리턴한다.(카운트 해야함)
     */

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            int y = move - 1;

            for (int x = 0; x < board.length; x++) {
                int pickedDoll = board[x][y];

                if (pickedDoll != 0) {
                    board[x][y] = 0;

                    if (!stack.isEmpty() && stack.peek().equals(pickedDoll)) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(pickedDoll);
                    }

                    break;
                }
            }
        }

        return answer;
    }

}
