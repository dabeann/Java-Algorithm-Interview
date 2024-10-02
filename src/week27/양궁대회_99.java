package week27;

import java.util.*;

public class 양궁대회_99 {

    int[] answerInfo = new int[11];
    int maxScoreGap = -1;

    public int[] solution(int n, int[] info) {
        int[] lionInfo = new int[11];

        backtrack(n, n, info, lionInfo, 0, 0);

        if (maxScoreGap <= 0) {
            return new int[]{-1};
        } else {
            return answerInfo;
        }
    }

    private void backtrack(int arrowsLeft, int n, int[] info, int[] lionInfo, int index, int scoreGap) {
        if (arrowsLeft == 0 || index == 11) {
            if (arrowsLeft > 0) {
                lionInfo[10] += arrowsLeft; // 남은 화살은 0점에 모두 쏘기
            }
            // 점수 계산
            int lionScore = 0, peachScore = 0;
            for (int i = 0; i < 11; i++) {
                if (info[i] == 0 && lionInfo[i] == 0) continue;
                if (info[i] >= lionInfo[i]) {
                    peachScore += 10 - i;
                } else {
                    lionScore += 10 - i;
                }
            }
            int currentGap = lionScore - peachScore;
            if (currentGap > maxScoreGap) {
                maxScoreGap = currentGap;
                answerInfo = lionInfo.clone(); // 현재 점수 차이가 더 크면 업데이트
            } else if (currentGap == maxScoreGap) {
                // 점수 차이가 같을 때, 더 낮은 점수를 많이 맞힌 경우 우선
                for (int i = 10; i >= 0; i--) {
                    if (lionInfo[i] != answerInfo[i]) {
                        if (lionInfo[i] > answerInfo[i]) {
                            answerInfo = lionInfo.clone();
                        }
                        break;
                    }
                }
            }
            if (arrowsLeft > 0) {
                lionInfo[10] -= arrowsLeft; // 남은 화살 원상 복구
            }
            return;
        }

        // 화살 쏠 수 있는 경우 탐색
        for (int i = index; i < 11; i++) {
            if (arrowsLeft >= info[i] + 1) {
                lionInfo[i] = info[i] + 1;
                backtrack(arrowsLeft - lionInfo[i], n, info, lionInfo, i + 1, scoreGap);
                lionInfo[i] = 0;
            }
        }

        // 해당 점수 넘기고 다른 점수에서 탐색
        if (index < 11) {
            backtrack(arrowsLeft, n, info, lionInfo, index + 1, scoreGap);
        }
    }
}
