package main.java.programmers.lv2;

import java.util.ArrayList;
import java.util.List;

// LV2 [3차] 방금그곡
public class Solution14 {
    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        solution14.solution("ABCDEFG",new String[] {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"});

    }

    public int getIntegerTime(String time) {
        String[] hhmm = time.split(":");
        int hh = Integer.parseInt(hhmm[0]);
        int mm = Integer.parseInt(hhmm[1]);
        return hh * 60 + mm;
    }

    public int getPlayTime(String start, String end) {
        return getIntegerTime(end) - getIntegerTime(start);
    }

    public String replaceSharp(String str) {
        return str.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a");
    }

    public String solution(String m, String[] musicinfos) {
        List<Music> matchList = new ArrayList<>();
        m = replaceSharp(m);
        for (String s : musicinfos) {
            String[] infos = s.split(",");

            int playTime = getPlayTime(infos[0], infos[1]);
            String title = infos[2];
            String melody = replaceSharp(infos[3]);
            String entireMel = "";

            for (int i = 0; i < playTime; i++) {
                int idx = i % melody.length();
                entireMel += melody.charAt(idx);
            }

            if (entireMel.contains(m)) {
                matchList.add(new Music(title, playTime));
            }
        }

        if (matchList.isEmpty()) return "(None)";

        String answer = "";
        int maxPlay = Integer.MIN_VALUE;

        for (Music music : matchList) {
            if (maxPlay < music.playTime) {
                answer = music.title;
                maxPlay = music.playTime;
            }
        }

        return answer;
    }

    class Music {
        String title;
        int playTime;

        public Music(String title, int playTime) {
            this.title = title;
            this.playTime = playTime;
        }
    }

}
