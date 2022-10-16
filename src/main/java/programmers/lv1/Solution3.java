package main.java.programmers.lv1;

import java.util.Arrays;

public class Solution3 {

    public void testDy(){
        // 로또의 최고 순위와 최저 순위
        int[] lottos = new int[]{44, 1, 0, 0, 31, 25};
        int[] win_nums = new int[]{31, 10, 45, 1, 6, 19};

        solution(lottos, win_nums);
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        // 1. 오른차순 정렬
        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int unk = 0; //0개수
        int match = 0; //맞은 개수
        // 2. 딩첨 개수 체크
        for(int lot : lottos){
            if (lot == 0){
                unk ++;
                continue;
            }
            for(int j = 0; j < win_nums.length; j++){
                if(win_nums[j] > lot){ // 없음
                    break;
                }
                if(win_nums[j] == lot){
                    match ++;
                }
            }
        }

        // 3. 0 개수에 따라 최고 수 최저 수 구하기
        answer[0] = getGradle(match + unk);
        answer[1] = getGradle(match);

        return answer;
    }

    public int getGradle(int n){
        switch (n) {
            case 6 :
                return 1;
            case 5 :
                return 2;
            case 4 :
                return 3;
            case 3 :
                return 4;
            case 2 :
                return 5;
            default:
                return  6;
        }
    }
}
