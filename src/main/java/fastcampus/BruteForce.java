package main.java.fastcampus;

import java.io.*;
import java.util.StringTokenizer;

// 완전 탐색
public class BruteForce {
    static StringBuilder sb = new StringBuilder();
    static void input() {
        FastReader scan = new FastReader();
        M = scan.nextInt();
        N = scan.nextInt();
        chars = new char[N + 1];
        selected = new int[M + 1];
        String[] tokens = scan.nextLine().split(" ");
        for (int i = 1; i <= N; i++) {
            chars[i] = tokens[i - 1].charAt(0);
        }
    }

    static int N, M;
    static char[] chars;
    static int[] selected;

    static boolean isVowel(char x) {
        return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
    }

    static void rec_func(int k) {
        if (k == M + 1) {
            int vowel = 0;
            int consonant = 0;
            // 선택한 문자들이 조건을 만족하는 지 확인
            /* TODO */
        } else {
            // 알파벳 순으로 증가하는 순서로 고르기
            /* TODO */
        }
    }

    public static void main(String[] args) {
        input();

        rec_func(1);
        System.out.println(sb.toString());
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
