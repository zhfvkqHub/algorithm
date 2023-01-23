package main.java.programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// LV2 메뉴 리뉴얼
public class Solution68 {

    public static void main(String[] args) {
        Solution68 solution68 = new Solution68();
        solution68.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4});
    }

    static HashMap<String,Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> result = new ArrayList<>();

        for(String order : orders) {
            ArrayList<String> arr = new ArrayList<>();

            for(String X : order.split("")) arr.add(X);

            Collections.sort(arr);
            for(int i =0;i<course.length;i++)
                reculsion(arr, result, 0, arr.size(), course[i]);
        }

        ArrayList<String> arr2 = new ArrayList<>();
        for(String m : map.keySet()) {
            if(map.get(m) >= 2) arr2.add(m);
        }

        ArrayList<String> arr3 = new ArrayList<>();
        for(int i=0; i<course.length; i++) {
            int max =0 ;

            for(int j=0; j<arr2.size(); j++) {
                if(arr2.get(j).length()==course[i]) {
                    if(max < map.get(arr2.get(j))) max = map.get(arr2.get(j));
                }
            }
            for(String Z: map.keySet()) {
                if(Z.length()==course[i]) {
                    if(map.get(Z) == max) arr3.add(Z);
                }
            }
        }

        Collections.sort(arr3);
        String[] answer = new String[arr3.size()];

        for(int i =0; i<arr3.size(); i++) answer[i] = arr3.get(i);

        return answer;
    }

    static void reculsion(List<String> arr, List<String> result, int index, int n, int r) {

        if (r == 0) {
            String result2 = result.toString()
                    .replace("[","")
                    .replace(", ","")
                    .replace("]","");

            map.put(result2, map.getOrDefault(result2, 0) + 1);
            return;
        }

        for (int i = index; i < n; i++) {
            result.add(arr.get(i));
            reculsion(arr, result, i + 1, n, r - 1);
            result.remove(result.size() - 1);
        }
    }


}


