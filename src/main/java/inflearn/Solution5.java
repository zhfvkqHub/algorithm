package main.java.inflearn;

import java.util.HashMap;
import java.util.Scanner;

// 아나그램(HashMap)
public class Solution5 {

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(solution5.solution(s1, s2));

    }

    private boolean solution(String s1, String s2) {

        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s1.toCharArray()){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        for(char x : s2.toCharArray()){
            if(!map.containsKey(x) || map.get(x) == 0)
                return false;

            map.put(x, map.get(x)-1);
        }
        return true;
    }

}
