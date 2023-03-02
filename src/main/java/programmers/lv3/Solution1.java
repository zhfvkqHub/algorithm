package main.java.programmers.lv3;

import java.util.Arrays;

// 등굣길
public class Solution1 {

    public static void main(String[] args) {
        Solution1 Solution1 = new Solution1();
        Solution1.solution(4, 3, new int[][]{{2,2}});
    }
    private final int DIVINE_NUMBER = 1000000007;

    public int solution(int m, int n, int[][] puddles) {
        long[][] coord = new long[n+1][m+1];

        for(int i=0; i<n+1; i++){
            Arrays.fill(coord[i], (i==0) ? 0l : -1l);
            coord[i][0] = 0l;
        }

        coord[1][1] = 1;
        for(int[] puddle : puddles)
            coord[puddle[1]][puddle[0]] = 0l;

        for(int i=1; i < n+1; i++)
            for(int j=1; j < m+1; j++)
                if(coord[i][j] == -1)
                    coord[i][j] = (coord[i-1][j] + coord[i][j-1]) % DIVINE_NUMBER;

        return (int)coord[n][m];
    }
}



