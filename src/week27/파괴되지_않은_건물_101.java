package week27;

import java.util.*;

public class 파괴되지_않은_건물_101 {
    /*public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        for (int[] skillOp : skill) {
            int degree = skillOp[5];
            if (skillOp[0] == 1) {
                degree = -skillOp[5];
            }
            for (int i = skillOp[1]; i <= skillOp[3]; i++) {
                for (int j = skillOp[2]; j <= skillOp[4]; j++) {
                    board[i][j] += degree;
                }
            }
        }

        for (int[] row : board) {
            for (int value : row) {
                if (value > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }*/

    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] diff = new int[n + 1][m + 1];

        for (int[] skillOp : skill) {
            int type = skillOp[0];
            int r1 = skillOp[1];
            int c1 = skillOp[2];
            int r2 = skillOp[3];
            int c2 = skillOp[4];
            int degree = (type == 1 ? -skillOp[5] : skillOp[5]);

            diff[r1][c1] += degree;
            diff[r1][c2 + 1] -= degree;
            diff[r2 + 1][c1] -= degree;
            diff[r2 + 1][c2 + 1] += degree;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }

        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += diff[i][j];
                if (board[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
