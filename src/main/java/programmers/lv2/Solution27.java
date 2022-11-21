package main.java.programmers.lv2;

// LV2 [1차] 프렌즈4블록
public class Solution27 {

    public static void main(String[] args) {
        Solution27 solution27 = new Solution27();
        solution27.solution(4 ,5 ,new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
    }
    
    int pang;

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] game = new char[m][n];

        for (int inx = 0; inx < m; inx++) {
            for (int jnx = 0; jnx < n; jnx++) {
                game[inx][jnx] = board[inx].charAt(jnx);
            }
        }
        pang = 0;
        int check = 0;

        clear(m, n, game);
        set(m, n, game);

        while(pang != check) {
            check = pang;
            clear(m, n, game);
            set(m, n, game);
        }

        answer = pang;

        return answer;
    }

    public void clear(int m, int n, char[][] game) {

        for (int inx = 0; inx < m - 1; inx++) {
            for (int jnx = 0; jnx < n - 1; jnx++) {

                char x = game[inx][jnx];
                if (x != '-' && game[inx][jnx + 1] == x && game[inx + 1][jnx] == x && game[inx + 1][jnx + 1] == x) {
                    game[inx][jnx] = '*';
                }

            }
        }

        for (int inx = m - 2; inx >= 0; inx--) {
            for (int jnx = n - 2; jnx >= 0; jnx--) {

                if (game[inx][jnx] == '*') {
                    game[inx][jnx] = '-';
                    pang++;
                    if (game[inx][jnx + 1] != '-') {
                        game[inx][jnx + 1] = '-';
                        pang++;
                    }
                    if (game[inx + 1][jnx] != '-') {
                        game[inx + 1][jnx] = '-';
                        pang++;
                    }
                    if (game[inx + 1][jnx + 1] != '-') {
                        game[inx + 1][jnx + 1] = '-';
                        pang++;
                    }
                }

            }
        }
    }

    public void set(int m, int n, char[][] game) {
        for (int jnx = 0; jnx < n; jnx++) {
            String temp = "";
            for (int inx = m - 1; inx >= 0; inx--) {
                if(game[inx][jnx] != '-') {
                    temp += Character.toString(game[inx][jnx]);
                }
            }

            for(int inx = temp.length(); inx < m; inx++) {
                temp += "-";
            }

            for (int inx = m - 1; inx >= 0; inx--) {
                game[inx][jnx] = temp.charAt(m - 1 - inx);
            }
        }
    }
}
