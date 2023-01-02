package main.java.programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;

// LV2 [3차] n진수 게임
public class Solution54 {

    public static void main(String[] args) {
        Solution54 solution54 = new Solution54();
        solution54.solution(2, 4, 2, 1);
    }

    public String solution(int n, int t, int m, int p) {
        StringBuffer sb = new StringBuffer();
        sb.append(0);

        for(int i=1; ; i++) {
            sb.append(number(n, i));
            if(sb.length() > m*t) {
                break;
            }
        }

        String x = "";

        for(int i=p-1; t>0; i+=m) {
            x += sb.toString().charAt(i);
            t--;
        }
        return x;
    }
    public static String number(int n, int i) {
        ArrayList<String> value = new ArrayList<>();

        while(i > 0) {
            int temp = i % n;
            if(temp > 9) {
                switch(temp) {
                    case 10 : value.add("A"); break;
                    case 11 : value.add("B"); break;
                    case 12 : value.add("C"); break;
                    case 13 : value.add("D"); break;
                    case 14 : value.add("E"); break;
                    case 15 : value.add("F"); break;
                    default : break;
                }
            } else {
                value.add(Integer.toString(i%n));
            }
            i = i/n;
        }

        Collections.reverse(value);

        String result = "";
        for(int j=0; j<value.size(); j++) {
            result += value.get(j);
        }
        return result;
    }
}


