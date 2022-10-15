package main.java.programmers.lv2;

// 완전탐색 > 카펫
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.solution(10, 2);
    }
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};

        int sum = brown + yellow;
        for(int i=sum/2; i>2; i--){
            if(sum % i == 0 && ((i-2)*(sum/i-2)) == yellow){
                answer[0] = i;
                answer[1] = sum/i;
                break;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
        return answer;
    }
}
