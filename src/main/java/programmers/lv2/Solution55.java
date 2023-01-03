package main.java.programmers.lv2;

// LV2 문자열 압축
public class Solution55 {

    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        solution55.solution("aabbaccc");
    }

    public int solution(String s) {

        int answer = s.length();

        StringBuilder sb = new StringBuilder();
        StringBuilder encryption = new StringBuilder();
        int max = s.length()/2;

        for (int i=1; i<=max; i++) {

            sb.append(s);
            String pivot = sb.substring(0, i);
            sb.delete(0, i);
            int count = 1;

            while(sb.length() >= i) {
                String newPivot = sb.substring(0, i);
                if(pivot.equals(newPivot)) {
                    count+=1;
                } else {
                    if(count == 1) {
                        encryption.append(pivot);
                    } else {
                        encryption.append(count).append(pivot);
                    }
                    pivot = newPivot;
                    count = 1;
                }
                sb.delete(0, i);
            }

            if(count != 1) {
                encryption.append(count).append(pivot);
            }else {
                encryption.append(pivot);
            }

            encryption.append(sb);
            answer = Math.min(answer, encryption.length());
            encryption.setLength(0);
            sb.setLength(0);

        }
        return answer;
    }
}


