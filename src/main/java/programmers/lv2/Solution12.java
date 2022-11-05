package main.java.programmers.lv2;

// LV2 행렬의 곱셈
public class Solution12 {
    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();

        int[][] a = { { 1, 4 }, { 2, 2 }, { 4, 1 } };
        int[][] b = { { 3, 3 }, { 3, 3 } };

        solution12.solution(a,b);

    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr2[0].length; j++){
                int count = 0;
                for(int x = 0; x < arr1[0].length; x++){
                    count += (arr1[i][x] * arr2[x][j]);
                }
                answer[i][j] = count;
            }
        }
        return answer;
    }

}
