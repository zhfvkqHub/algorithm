package main.java.programmers.lv2;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// LV2 튜플
public class Solution13 {
    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        solution13.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");

    }

    public int[] solution(String s) {

        Map<String, Integer> map = new HashMap<>();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String n = matcher.group();
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int size = map.size();
        int[] answer = new int[size];
        for (String key: map.keySet()) {
            answer[size - map.get(key)] = Integer.parseInt(key);
        }

        return answer;
    }

}
