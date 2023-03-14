package main.java.programmers.lv1;

/**
 * 두 정수 사이의 합
 * https://school.programmers.co.kr/learn/courses/30/lessons/12912?language=javascript
 */
public class Solution13 {
    public static void main(String[] args) {
        Solution13 Solution13 = new Solution13();
        Solution13.solution(3, 5);
    }

    public long solution(int a, int b) {
        long answer = 0;
        int c;

        if(a > b){
            c = a;
            a = b;
            b = c;
        }

        for(int i = a; i <= b; i++)
            answer = answer + i;

        return answer;
    }

}


