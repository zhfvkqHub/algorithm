package main.java.programmers.lv2;

// LV2 양궁대회
public class Solution16 {
    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        solution16.solution(5, new int[]{2,1,1,1,0,0,0,0,0,0,0});

    }

    int best;
    int lowest = 10;

    public int[] solution(int n, int[] info) {
        int index = 0;
        int score = 0;
        int[] temp = new int[11];
        int[] answer = new int[11];

        for (int i = 0; i < 10; i++) {
            if (info[i] > 0) {
                score -= 10 - i;
            }
        }
        while (index < 10) {
            dfs(n, info, temp, answer, index++, score);
        }
        return best > 0 ? answer : new int[] { -1 };
    }

    void dfs(int n, int[] info, int[] temp, int[] answer, int index, int score) {
        int apeach = info[index] + 1;
        int t = index;

        if (n >= apeach) {
            n -= apeach;
            score += (10 - index) * (apeach > 1 ? 2 : 1);
            temp[index++] = apeach;
            if (n > 0) {
                while (index < 10) {
                    dfs(n, info, temp, answer, index++, score);
                }
            }
        } else {
            index = 10;
        }
        if (score > best || score == best && index > lowest) {
            best = score;
            lowest = index;
            System.arraycopy(temp, 0, answer, 0, 11);
            answer[index] = n;
        }
        temp[t] = 0;
    }

}
