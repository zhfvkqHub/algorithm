package main.java.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Info implements Comparable<Info>{
    int age=0;
    String name="";

    Info(int x, int y){
        this(0,"");
    }
    Info(int age,String name){
        this.age=age;
        this.name=name;
    }

    @Override
    public int compareTo(Info a){
        return this.age - a.age;
    }
}

public class Solution {

    private static String[] arr = new String[]{"23 다연", "11 해피", "27 찬혁"};

//    public static void main(String[] args) {
//        solution(3);
//    }

    // 백준풀이..
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());//단어개수

        StringBuilder[] sb = new StringBuilder[201];//1<=나이<=200
        //객체생성
        for(int i = 0; i < sb.length; i++){
            sb[i] = new StringBuilder();
        }
        //sb[]를 이용해 입력저장
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            //sb[age].append(age+" "+name+"\n"); 와.. ㄷㄷ
            sb[age].append(age).append(" ").append(name).append("\n");
        }
        for(StringBuilder i : sb){
            System.out.print(i);
        }
    }

    private static void solution(int num) {
        ArrayList<Info> list = new ArrayList<>();

        // input으로 받을 경우
//        Scanner sc = new Scanner(System.in);
//        num = sc.nextInt();
//        String[] arr = new String[num];
//        for(int i = 0; i < arr.length; i++){
//            String input = sc.next();
//            input += " " + sc.next();
//            arr[i] = input;
//        }

        Info a;
        for(int i  = 0; i < num; i++){
            String[] n = arr[i].split(" ");
            list.add(new Info(Integer.parseInt(n[0]),n[1]));
        }

        Collections.sort(list);

        for(int i = 0; i < num; i ++){
            System.out.println(list.get(i).age + " " + list.get(i).name);
        }

    }
}
