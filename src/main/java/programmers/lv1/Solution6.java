package main.java.programmers.lv1;

public class Solution6 {

    public void testDy(){
        // 약수의 합
        int n = 12;
        solution(n);
    }


    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i <= (int)n/2; i++){
            if(n % i == 0){
                answer += i;
            }
        }
        answer += n;

        return answer;
    }
}
