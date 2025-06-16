
public class Solution {
    static int[] staticInfo;
    static int maxGap = 0;
    static int[] maxInfo = new int[11];
    static int apeachScore;
    static int lionScore;
    boolean lionCanWin = false;
    int[] lastArrow = new int[2];

    public int[] solution(int n, int[] info) {
        staticInfo = info;
        recur(0, n, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0);
        if (!lionCanWin || maxGap == 0) {
            return new int[]{-1};
        }
        return maxInfo;
    }

    private void recur(int idx, int remainArrow, int[] currentInfo, int lastArrowIdx) {
        if (idx == 11) {
            checkScore(currentInfo);
            int gap = lionScore - apeachScore;
            if (gap >= maxGap) {
                if (gap > maxGap || lastArrowIdx > lastArrow[0] || lastArrowIdx == lastArrow[0] && currentInfo[lastArrowIdx] > lastArrow[1]) {
                    lastArrow[0] = lastArrowIdx;
                    lastArrow[1] = currentInfo[lastArrowIdx];
                    maxGap = gap;
                    lionCanWin = true;
                    copy(currentInfo);
                }
            }
            return;
        }

        if (remainArrow > staticInfo[idx]) {
            currentInfo[idx] = staticInfo[idx] + 1;
            recur(idx + 1, remainArrow - staticInfo[idx] - 1, currentInfo, idx);
            currentInfo[idx] = 0;
        }

        if (idx == 10 && remainArrow > 0) {
            currentInfo[idx] = remainArrow;
            recur(idx + 1, 0, currentInfo, idx);
            currentInfo[idx] = 0;
        } else {
            recur(idx + 1, remainArrow, currentInfo, lastArrowIdx);
        }
    }

    private void checkScore(int[] currentInfo) {
        apeachScore = 0;
        lionScore = 0;
        for (int i = 0; i < currentInfo.length; i++) {
            int score = 10 - i;
            if (currentInfo[i] > staticInfo[i]) {
                lionScore += score;
            } else if (staticInfo[i] != 0) {
                apeachScore += score;
            }
        }
    }

    private void copy(int[] currentInfo) {
        for (int i = 0; i < currentInfo.length; i++) {
            maxInfo[i] = currentInfo[i];
        }
    }
}
