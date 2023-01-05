package main.java.programmers.lv2;

import java.util.ArrayList;

// LV2 수식 최대화
public class Solution56 {

    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        solution56.solution("100-200*300-500+20");
    }


    public long solution(String expression) {

        String[] longArr = expression.split("[^0-9]");
        ArrayList<Long> longList = new ArrayList<Long>();
        for (int i = 0; i < longArr.length; i++)
            longList.add(Long.parseLong(longArr[i]));

        String[] opsArr = expression.split("[0-9]+");
        ArrayList<String> opsList = new ArrayList<String>();
        for (int i = 1; i < opsArr.length; i++)
            opsList.add(opsArr[i]);

        ArrayList<Long> longTemp;
        ArrayList<String> opsTemp;
        long max = 0;

        longTemp = new ArrayList<>(longList);
        opsTemp = new ArrayList<>(opsList);
        calcProc(longTemp, opsTemp, "+", "-", "*");
        max = Math.max(max, Math.abs(longTemp.get(0)));

        longTemp = new ArrayList<>(longList);
        opsTemp = new ArrayList<>(opsList);
        calcProc(longTemp, opsTemp, "+", "*", "-");
        max = Math.max(max, Math.abs(longTemp.get(0)));

        longTemp = new ArrayList<>(longList);
        opsTemp = new ArrayList<>(opsList);
        calcProc(longTemp, opsTemp, "-", "+", "*");
        max = Math.max(max, Math.abs(longTemp.get(0)));

        longTemp = new ArrayList<>(longList);
        opsTemp = new ArrayList<>(opsList);
        calcProc(longTemp, opsTemp, "-", "*", "+");
        max = Math.max(max, Math.abs(longTemp.get(0)));

        longTemp = new ArrayList<>(longList);
        opsTemp = new ArrayList<>(opsList);
        calcProc(longTemp, opsTemp, "*", "+", "-");
        max = Math.max(max, Math.abs(longTemp.get(0)));

        longTemp = new ArrayList<>(longList);
        opsTemp = new ArrayList<>(opsList);
        calcProc(longTemp, opsTemp, "*", "-", "+");
        max = Math.max(max, Math.abs(longTemp.get(0)));

        return max;
    }

    public void calcProc(ArrayList<Long> longLi, ArrayList<String> opsLi, String op1, String op2, String op3) {
        calc(longLi, opsLi, op1);
        calc(longLi, opsLi, op2);
        calc(longLi, opsLi, op3);

    }

    public void calc(ArrayList<Long> longLi, ArrayList<String> opsLi, String ops) {

        int i = 0;
        int length = opsLi.size();

        while (i < length) {
            if (ops.equals(opsLi.get(i))) {
                switch (ops) {
                    case "+":
                        longLi.set(i, longLi.get(i) + longLi.get(i + 1));
                        break;
                    case "-":
                        longLi.set(i, longLi.get(i) - longLi.get(i + 1));
                        break;
                    case "*":
                        longLi.set(i, longLi.get(i) * longLi.get(i + 1));
                        break;
                }
                longLi.remove(i + 1);
                opsLi.remove(i);
                i--;
                length--;
            }
            i++;
        }

    }


}


