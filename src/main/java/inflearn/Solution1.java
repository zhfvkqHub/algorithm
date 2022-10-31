package main.java.inflearn;

import java.util.Scanner;

// dynamic programming(동적계획법) > 계단오르기
public class Solution1 {
    static int[] dy;

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dy = new int[n+1];
        System.out.println(solution1.solution(n));

    }

    private int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;

        for(int i=3; i<=n; i++){
            dy[i] = dy[i-2]+dy[i-1];
        }

        return dy[n];
    }

}
