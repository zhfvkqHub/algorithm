package main.java.programmers.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// LV2 오픈채팅방
public class Solution20 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        solution20.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});

    }

    public String[] solution(String[] record) {
        HashMap<String, String> codeMap = new HashMap<>();
        codeMap.put("enter","들어왔습니다.");
        codeMap.put("leave","나갔습니다.");

        HashMap<String, String> uidMap = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(String str:record){

            String[] split = str.split("\\s+");
            String code = split[0];
            String uid = split[1];
            if(split.length > 2) {
                String name = split[2];
                uidMap.put(uid, name);
            }
            if(!"Change".equalsIgnoreCase(code)){
                list.add(code +" "+uid);
            }

        }

        String[] answer = new String[list.size()];

        for(int i=0;i<answer.length;i++){

            String[] split = list.get(i).split("\\s+");
            String name = uidMap.get(split[1]);
            answer[i] = name+"님이 "+ codeMap.get(split[0].toLowerCase());
            
        }

        return answer;
    }
}
