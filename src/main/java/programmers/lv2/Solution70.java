package main.java.programmers.lv2;

// LV2 k진수에서 소수 개수 구하기
public class Solution70 {

    public static void main(String[] args) {
        Solution70 solution70 = new Solution70();
        solution70.solution(437674, 3);
    }

    public int solution(int n, int k) {
        int answer = 0;
        String nt = Integer.toString(n,k);

        String[] strStlNum = nt.split("0");
        for(String s : strStlNum){
            if(!"".equals(s) && isPrime(s))
                answer++;
        }

        return answer;
    }

    private boolean isPrime(String v){
        long val = Long.valueOf(v);

        if(val < 2) return false;

        for(long i=2; i<=Math.sqrt(val); i++){
            if(val % i == 0) return false;
        }
        return true;
    }
}


