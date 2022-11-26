package main.java.programmers.lv2;

import java.util.HashMap;

// LV2 할인 행사
public class Solution30 {

    public static void main(String[] args) {
        Solution30 solution30 = new Solution30();
        solution30.solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1}
        ,new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"});
    }

    public int solution(String[] want, int[] number, String[] discount) {

        int answer = 0;
        int cnt = 0;
        int n = number.length;

        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i < n;i++){
            map.put(want[i], i);
            cnt += number[i];
        }

        for(int i = 0 ; i <= discount.length - cnt ; i++){
            int[] now = new int[n];

            for(int j = i ; j < i + cnt; j++){

                if(map.containsKey(discount[j])){
                    int a = map.get(discount[j]);
                    now[a] ++;
                }else break;

            }
            boolean flag = false;

            for(int j=0; j<now.length; j++){

                if(now[j] == number[j])
                    flag = true;
                else{
                    flag = false;
                    break;
                }

            }

            if(flag) answer++;
        }

        return answer;
    }
}

