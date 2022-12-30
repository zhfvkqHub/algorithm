package main.java.programmers.lv2;

import java.util.HashMap;
import java.util.Map;

// LV2 전화번호 목록
public class Solution51 {

    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        solution51.solution(new String[]{"119", "97674223", "1195524421"});
    }

    public boolean solution(String[] phoneBook) {
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < phoneBook.length; i++) {
            map.put(phoneBook[i], i);
        }

        for(int i = 0; i < phoneBook.length; i++) {
            for(int j = 0; j < phoneBook[i].length(); j++) {

                if(map.containsKey(phoneBook[i].substring(0,j)))
                    return false;

            }
        }
        return true;
    }
}


