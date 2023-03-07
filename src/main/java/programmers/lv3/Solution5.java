package main.java.programmers.lv3;

import java.util.*;

// 베스트앨범
public class Solution5 {

    public static void main(String[] args) {
        Solution5 Solution5 = new Solution5();
        Solution5.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
    }

    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        answer[0] = 1;
        answer[1] = gems.length;

        int compare = gems.length-1;
        int start = 0;
        int end = 0;
        int flag = 0;

        Map<String, Integer> gemMap = new HashMap<>();

        for(int i=0; i<gems.length; i++){
            if(!gemMap.containsKey(gems[i]))
                gemMap.put(gems[i], 0);
        }

        while(end < gems.length){

            if(flag < gemMap.size()){
                gemMap.put(gems[end], gemMap.get(gems[end]) + 1);
                if(gemMap.get(gems[end]) == 1)
                    flag++;

                end++;
            }
            else{

                if((end-1) - start < compare){
                    answer[0] = start+1;
                    answer[1] = end;
                    compare = answer[1]-answer[0];
                }

                gemMap.put(gems[start],gemMap.get(gems[start])-1);

                if(gemMap.get(gems[start])==0)
                    flag--;

                start++;
            }
        }

        return answer;
    }
}



