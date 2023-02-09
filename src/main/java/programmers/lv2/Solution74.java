package main.java.programmers.lv2;

// LV2 호텔 대실
public class Solution74 {

    public static void main(String[] args) {
        Solution74 Solution73 = new Solution74();
        Solution73.solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"},{"14:10", "19:20"},{"18:20", "21:20"}});
    }

    public int solution(String[][] book_time) {
        int answer = 0;
        int[] room = new int[60 * 24 + 10];

        for (String[] str : book_time) {
            room[getMinute(str[0])] += 1;
            room[getMinute(str[1])+10] += -1;
        }

        for (int i = 1; i < room.length; i++) {
            room[i] += room[i-1];
            answer = Math.max(answer, room[i]);
        }

        return answer;
    }

    private int getMinute(String str) {
        String[] arr = str.split(":");
        return (Integer.parseInt(arr[0]) * 60) + Integer.parseInt(arr[1]);
    }

}


