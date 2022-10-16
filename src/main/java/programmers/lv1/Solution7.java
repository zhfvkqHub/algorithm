package main.java.programmers.lv1;

public class Solution7 {

    public void testDy(){
        // 내적
        int a[] = new int[]{1,2,3,4};
        int b[] = new int[]{-3,-1,0,2};
        solution(a,b);
    }

    public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i=0; i<a.length; i++){
            answer += a[i] * b[i];
        }
        return answer;
    }
}
