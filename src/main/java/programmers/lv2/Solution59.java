package main.java.programmers.lv2;

// LV2 숫자의 표현
public class Solution59 {

    public static void main(String[] args) {
        Solution59 solution59 = new Solution59();
        solution59.solution(15);
    }


    public int solution(int n) {
        int answer = 1;

        for (int i=1; i<n/2+1; i++) {

            int sum = 0;

            for (int j=i; j<=n/2+1 ; j++) {
                sum += j;
                if (sum == n) {
                    answer++;
                    break;
                }

                if (sum > n) break;
            }
        }
        return answer;
    }
}


