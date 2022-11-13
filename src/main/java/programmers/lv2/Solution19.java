package main.java.programmers.lv2;

import java.util.ArrayList;

// LV2 [1차] 뉴스 클러스터링
public class Solution19 {
    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        solution19.solution("FRANCE", "french");

    }

    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        int size1 = str1.length();
        ArrayList<String> list1 = new ArrayList<>();
        for(int i=0; i<size1-1; i++) {
            String s = "";
            if((int)str1.charAt(i) < 65 || (int)str1.charAt(i) > 90) continue;
            s += str1.charAt(i);
            if((int)str1.charAt(i+1) < 65 || (int)str1.charAt(i+1) > 90) continue;
            s += str1.charAt(i+1);
            list1.add(s);
        }

        str2 = str2.toUpperCase();
        int size2 = str2.length();
        ArrayList<String> list2 = new ArrayList<>();
        for(int i=0; i<size2-1; i++) {
            String s = "";
            if((int)str2.charAt(i) < 65 || (int)str2.charAt(i) > 90) continue;
            s += str2.charAt(i);
            if((int)str2.charAt(i+1) < 65 || (int)str2.charAt(i+1) > 90) continue;
            s += str2.charAt(i+1);
            list2.add(s);
        }

        ArrayList<String> list3 = new ArrayList<>();
        for(int i=0; i<list1.size(); i++) {
            for(int j=0; j<list2.size(); j++) {
                if(list1.get(i).equals(list2.get(j))) {
                    String s = list1.get(i);
                    list3.add(s);
                    list1.remove(s);
                    list2.remove(s);
                    i--;
                    break;
                }
            }
        }
        //합집합
        double allSize = list1.size() + list2.size() + list3.size();
        //교집합
        double sameSize = list3.size();
        double d1 = sameSize / allSize;
        if(allSize == 0 && sameSize == 0) {
            d1 = 1.0;
        }
        double d2 = d1 * 65536;
        answer = (int) d2;
        return answer;
    }
}
