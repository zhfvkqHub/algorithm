package main.java.programmers.lv2;

import java.util.HashSet;

// 영어 끝말밋기
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        solution1.solution(n, words);
    }
    public int[] solution(int n, String[] words) {

        int[] answer = {0,0};
        char chEnd = words[0].charAt(words[0].length() - 1);
        char chStart;
        System.out.print(chEnd + " ");

        HashSet<String> log = new HashSet<>();
        log.add(words[0]);

        for (int i = 1; i < words.length; i++) {

            chStart = words[i].charAt(0);
            log.add(words[i]);

            if (chEnd != chStart || log.size() != i + 1) {
                answer[0] = (i % n)+1;
                answer[1] = (i / n)+1;
                break;
            }
            chEnd = words[i].charAt(words[i].length() - 1);
        }
        System.out.println("(" + answer[0] + ", " + answer[1] + ")");
        return answer;
    }
}
