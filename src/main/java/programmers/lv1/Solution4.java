package main.java.programmers.lv1;

public class Solution4 {
    public void testDy(){
        // 음양 더하기
        int[] absolutes = new int[]{100,100,3};
        boolean[] signs = new boolean[]{false,false,true};
        solution(absolutes, signs);
    }

     public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

         for(int i = 0; i < absolutes.length; i++){
             if(signs[i]){
                 answer += absolutes[i];
             }else{
                 answer -= absolutes[i];
             }
         }
        return answer;
    }
}
