package main.java.programmers.lv1;

import java.util.ArrayList;

public class Solution8 {

    public void testDy(){
        // 없는 숫자 더하기
        int numbers[] = new int[]{1,2,3,4,6,7,8,0};
        solution(numbers);
    }

    public int solution(int[] numbers) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList();
        for(int i = 0; i < 10; i++){
            list.add(i);
        }
        for(int k = 0; k < numbers.length; k++){
            list.remove(Integer.valueOf(numbers[k]));
        }
        for(int j = 0; j < list.size(); j++){
            answer += list.get(j);
        }
        return answer;

//        [BEST 풀이] 다 더한 값에서 빼버림..
//        int sum = 45;
//        for (int i : numbers) {
//            sum -= i;
//        }
//        return sum;
    }
}
