package week27;

import java.util.*;

public class 사라지는_발판_102 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        return play(board, aloc[0], aloc[1], bloc[0], bloc[1]).moveCount;
    }

    private static class Result {
        boolean win;      // 해당 턴에서 승리 여부
        int moveCount;    // 움직인 횟수

        Result(boolean win, int moveCount) {
            this.win = win;
            this.moveCount = moveCount;
        }
    }

    private Result play(int[][] board, int x1, int y1, int x2, int y2) {
        if (board[x1][y1] == 0) {
            return new Result(false, 0);
        }

        boolean canWin = false;
        int minWinMove = Integer.MAX_VALUE;
        int maxLoseMove = 0;

        for (int i = 0; i < 4; i++) {
            int nx1 = x1 + dx[i];
            int ny1 = y1 + dy[i];

            if (nx1 < 0 || ny1 < 0 || nx1 >= board.length || ny1 >= board[0].length || board[nx1][ny1] == 0) {
                continue;
            }

            board[x1][y1] = 0;
            Result nextResult = play(board, x2, y2, nx1, ny1);
            board[x1][y1] = 1;

            if (!nextResult.win) {
                canWin = true;
                minWinMove = Math.min(minWinMove, nextResult.moveCount + 1);
            } else {
                maxLoseMove = Math.max(maxLoseMove, nextResult.moveCount + 1);
            }
        }

        if (canWin) {
            return new Result(true, minWinMove);
        } else {
            return new Result(false, maxLoseMove);
        }
    }
}
