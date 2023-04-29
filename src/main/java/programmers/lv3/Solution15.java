package main.java.programmers.lv3;

/**
 * 정수 삼각형
 * https://school.programmers.co.kr/learn/courses/30/lessons/43105?language=java
 */
public class Solution15 {

    public static void main(String[] args) {
        Solution15 Solution15 = new Solution15();
        Solution15.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
    }

    public int solution(int[][] triangle) {
        int[][] datas = new int[triangle.length][triangle.length];
        return sum(0, 0, triangle, datas);
    }

    public int sum(int i, int j, int[][] tri, int[][] datas){
        if(i == tri.length-1){
            return tri[i][j];
        }
        else if(datas[i][j] != 0){
            return datas[i][j];
        }
        else{
            datas[i][j] = tri[i][j] + Math.max(sum(i+1, j, tri, datas), sum(i+1, j+1, tri, datas));
            return datas[i][j];
        }
    }

}



