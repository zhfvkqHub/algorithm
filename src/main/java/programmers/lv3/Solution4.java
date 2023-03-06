package main.java.programmers.lv3;

import java.util.*;

// 베스트앨범
public class Solution4 {

    public static void main(String[] args) {
        Solution4 Solution4 = new Solution4();
        Solution4.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
    }

    public int[] solution(String[] genres, int[] plays) {
        int count = 0;
        HashMap<String, Integer> list = new HashMap<>();
        for(int i=0; i<genres.length; i++) {
            if(list.containsKey(genres[i]))
                list.put(genres[i], list.get(genres[i]) + plays[i]);
            else
                list.put(genres[i], plays[i]);
        }

        List<Integer> listValues = new ArrayList<>(list.values());
        List<String> sortedList1 = new ArrayList<>();
        Collections.sort(listValues, Collections.reverseOrder());

        for(int j : listValues) {
            for(Map.Entry<String, Integer> entry: list.entrySet()) {
                if(entry.getValue().equals(j))
                    sortedList1.add(entry.getKey());
            }
        }

        int[] answer = new int[sortedList1.size() * 2];

        for(String i: sortedList1) {
            HashMap<Integer, Integer> play = new HashMap<>();
            for(int k=0; k<genres.length; k++) {
                if(genres[k].equals(i))
                    play.put(k, plays[k]);
            }

            List<Integer> playValues = new ArrayList<>(play.values());
            List<Integer> sortedList2 = new ArrayList<>();
            Collections.sort(playValues, Collections.reverseOrder());

            for(int m : playValues) {
                for(Map.Entry<Integer, Integer> entry: play.entrySet()) {
                    if(entry.getValue() == m)
                        sortedList2.add(entry.getKey());
                }
            }

            if(playValues.size() == 1) {
                answer[count] = sortedList2.get(0);
                count++;
            }
            else {
                for(int l=0; l<2; l++) {
                    answer[count] = sortedList2.get(l);
                    count++;
                }
            }
        }
        if(answer.length > count)
            answer = Arrays.copyOfRange(answer, 0, count);

        return answer;
    }
}



