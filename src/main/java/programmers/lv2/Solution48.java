package main.java.programmers.lv2;

// LV2 그리디 > 조이스틱
public class Solution48 {

    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        solution48.solution("JEROEN");
    }

    public int solution(String name) {
        int answer = 0;
        int move=name.length()-1;

        int count;
        for(int i=0; i<name.length(); i++){

            answer += cal(name,i);
            count=i+1;

            while(count<name.length() && name.charAt(count)=='A'){
                count++;
            }

            move = Math.min(move, i*2 + (name.length() - count)); // 오른쪽 -> 왼쪽
            move = Math.min(move ,i + (name.length() - count) * 2); // 왼쪽 -> 오른쪽
        }
        return answer + move;
    }

    public static int cal(String name, int i){
        int max = 26;
        int count;

        count = name.charAt(i) - 'A';
        count = Math.min(max - count, count);

        return count;
    }

}


