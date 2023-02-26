package main.java.inflearn;

import java.util.HashMap;
import java.util.Scanner;

// 학급 회장(HashMap)
public class Solution4 {

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        System.out.println(solution4.solution(n, str));

    }

    private char solution(int n, String s) {
        char answer = ' ';
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0)+1);
        }

        int max = Integer.MIN_VALUE;
        for (char key : hashMap.keySet()){
            if(hashMap.get(key) > max){
                max = hashMap.get(key);
                answer = key;
            }
        }

        return answer;
    }

}
