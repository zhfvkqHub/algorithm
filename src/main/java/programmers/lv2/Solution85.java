package main.java.programmers.lv2;

/**
 * 당구 연습
 * https://school.programmers.co.kr/learn/courses/30/lessons/169198?language=java
 */
public class Solution85 {

    public static void main(String[] args) {
        Solution85 solution85 = new Solution85();
        solution85.solution(10, 10, 3, 7, new int[][]{{7, 7}, {2, 7},{7, 3}});
    }

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        for (int i = 0; i < balls.length; i++) {

            int[] ball = balls[i];
            int diffX = startX - ball[0];
            int diffY = startY - ball[1];

            int left = (startX + ball[0]) * (startX + ball[0]) + diffY * diffY;
            int right = ((m - startX) + (m - ball[0])) * ((m - startX) + (m - ball[0])) + diffY * diffY;
            int top = diffX * diffX + ((n - startY) + (n - ball[1])) * ((n - startY) + (n - ball[1]));
            int bottom = diffX * diffX + (startY + ball[1]) * (startY + ball[1]);

            int temp = Math.min(left, right);

            if (diffX == 0) {
                answer[i] = diffY > 0 ? Math.min(temp, top) : Math.min(temp, bottom);
            } else if (diffY == 0) {
                temp = Math.min(top, bottom);
                answer[i] = diffX > 0 ? Math.min(right, temp) : Math.min(left, temp);
            } else
                answer[i] = Math.min(temp, Math.min(top, bottom));


        }

        return answer;
    }
}



