package main.java.programmers.lv2;

// 행렬 테두리 회전하기
public class Solution81 {

    public static void main(String[] args) {
        Solution81 Solution80 = new Solution81();
        Solution80.solution(6, 6, new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}});
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows+1][columns+1];
        int num = 1;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                arr[i][j] = num++;
            }
        }

        for (int i = 0; i < queries.length; i++)
            answer[i] = rotate(arr, queries[i]);

        return answer;
    }

    private int rotate(int[][] arr, int[] queries) {

        int x1 = queries[0];
        int y1 = queries[1];
        int x2 = queries[2];
        int y2 = queries[3];

        int start = arr[queries[0]][queries[1]];
        int min = start;


        for (int i = x1; i < x2; i++) {
            arr[i][y1] = arr[i+1][y1];
            min = Math.min(min, arr[i + 1][y1]);
        }

        for (int i = y1; i < y2; i++) {
            arr[x2][i] = arr[x2][i + 1];
            min = Math.min(min, arr[x2][i + 1]);
        }

        for (int i = x2; i > x1; i--) {
            arr[i][y2] = arr[i-1][y2];
            min = Math.min(min, arr[i-1][y2]);
        }

        for (int i = y2; i > y1; i--) {
            arr[x1][i] = arr[x1][i - 1];
            min = Math.min(min, arr[x1][i - 1]);
        }

        arr[x1][y1 + 1] = start;
        return min;
    }
}



