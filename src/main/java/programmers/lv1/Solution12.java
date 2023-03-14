package main.java.programmers.lv1;

public class Solution12 {
    public static void main(String[] args) {
        Solution12 Solution12 = new Solution12();
        Solution12.solution(6);
    }

    public int solution(int num) {
        if (num == 1)
            return 0;

        long n = num;

        for (int i=0; i<500; i++) {
            if (n % 2 == 0)
                n /= 2;
            else {
                n *= 3;
                n += 1;
            }

            if (n == 1)
                return i+1;
        }

        return -1;
    }

}


