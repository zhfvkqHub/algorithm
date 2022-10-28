package main.java.baekjoon;

public class Solution10 {

    static String[] player = new String[]{"영수", "광수", "영철", "영기"};
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();

        solution10.playGame(player);
    }

    public String do369(int number){
        String num = String.valueOf(number);

        if(num.indexOf("3")>-1 || num.indexOf("6")>-1 || num.indexOf("9")>-1){
            return ": clap";
        }else{
            return ": " + num;
        }

    }
    public void playGame(String[] players){

        for(int i=0; i<100;){
            for(int j=0; j<4; j++){
                i++;
                System.out.println(players[j].concat(do369(i)));
            }
        }

    }

}
