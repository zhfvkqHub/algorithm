package main.java.inflearn;

import java.util.Scanner;

// dynamic programming(동적계획법) > 돌다리 건너기 경우의 수
public class Solution2 {
    static int[] dy;

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dy = new int[n+2];
        System.out.println(solution2.solution(n));

    }

    private int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;

        for(int i=3; i<=n+1; i++){
            dy[i] = dy[i-2]+dy[i-1];
        }

        return dy[n+1];
    }

}
