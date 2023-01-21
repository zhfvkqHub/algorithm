package main.java.programmers.lv2;

// LV2 쿼드압축 후 개수 세기
public class Solution67 {

    public static void main(String[] args) {
        Solution67 solution67 = new Solution67();
        solution67.solution(new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}});
    }

    static int COUNT_ZERO = 0;
    static int COUNT_ONE = 0;

    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int n = arr[0].length;

        check(arr, 0, 0, n);

        answer[0] = COUNT_ZERO;
        answer[1] = COUNT_ONE;

        return answer;
    }

    private static void check(int[][] arr, int x, int y, int n){
        int value = arr[x][y];

        if(n == 1){
            if(value == 0) COUNT_ZERO++;
            else COUNT_ONE++;

            return;
        }

        boolean isSame = true;

        for(int i = x; i < x+n; i++){
            for(int j = y; j < y+n; j++){
                if(value != arr[i][j]){
                    isSame = false;
                    break;
                }
            }

            if(!isSame) break;
        }

        if(isSame) {
            if(value == 0) COUNT_ZERO++;
            else COUNT_ONE++;

        } else{

            int newN = n/2;
            check(arr, x, y, newN);
            check(arr, x + newN, y, newN);
            check(arr, x, y + newN, newN);
            check(arr, x + newN, y + newN, newN);
        }

    }
}


