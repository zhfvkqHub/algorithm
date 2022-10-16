package main.java.programmers.lv1;

public class Solution10 {

    public void testDy(){
        // 약수의 개수와 덧셈
        int left = 13;
        int right = 17;

        solution(left,right);
    }

    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i<= right; i++){
            int cnt = 1;
            for(int j=1; j<=(int)i/2; j++){
                if(i % j == 0){
                    cnt ++;
                }
            }
            if(cnt % 2 == 0){
                answer += i;
            }else{
                answer -= i;
            }
        }
        return answer;
    }
}
