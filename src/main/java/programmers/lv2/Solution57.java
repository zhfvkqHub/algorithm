package main.java.programmers.lv2;

import java.util.ArrayList;
import java.util.HashMap;

// LV2 후보키
public class Solution57 {

    public static void main(String[] args) {
        Solution57 solution57 = new Solution57();
        solution57.solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}});
    }


    public boolean check(ArrayList<Integer> answer, int caseNumber){

        for(int i=0; i< answer.size(); i++){

            if((answer.get(i)&caseNumber) == answer.get(i))
                return false;

        }

        return true;
    }

    public int solution(String[][] relation){
        int answer;

        int n = relation.length;
        int m = relation[0].length;

        ArrayList<Integer> result = new ArrayList<>();
        for(int i=1; i< (1<<m); i++){

            HashMap<String, String> hm = new HashMap<>();

            for(int j=0; j<n; j++){
                String tempCandidate="";
                for(int k=0; k<m; k++){

                    if(( i & (1<<k)) > 0){
                        tempCandidate+=relation[j][k];
                    }

                }
                System.out.println(tempCandidate);
                hm.put(tempCandidate, tempCandidate);
            }

            if(hm.size()==n && check(result, i)){
                result.add(i);
            }
        }
        answer = result.size();

        return answer;
    }

}


