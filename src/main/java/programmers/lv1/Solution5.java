package main.java.programmers.lv1;

import java.util.*;
import java.util.stream.Collectors;


public class Solution5 {

    public void testDy(){
        // 신고 결과 받기
        String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        solution(id_list, report, k);

    }

    /* TIME OVER!!!!! */
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String,List<String>> map = new HashMap<>();

        for(int i = 0; i < id_list.length; i++){
            List<String> list = new ArrayList<>();
            for(String re : report){
                String[] reNm = re.split(" ");
                if (reNm[1].equals(id_list[i])){ // 신고당함.
                    if(reNm[0].equals(reNm[1])) // 본인 신고
                        continue;
                    if(list.contains(reNm[0])) // 재신고
                        continue;

                    list.add(reNm[0]);
                }
                map.put(id_list[i],list);
            }
        }

        Map<String,Integer> m = new HashMap<>();
        for (String id : id_list){
            List<String> idNm = map.get(id);
            if(idNm.size() >= k){
                for(String i : idNm){
                    if(m.containsKey(i)){
                        m.put(i, m.get(i)+1);
                    }else{
                        m.put(i, 1);
                    }
                }
            }
        }

        for(int i = 0; i < id_list.length; i++){
            int su = 0;
            if(m.get(id_list[i]) != null){
                su = m.get(id_list[i]);
            }
            answer[i] = su;
        }

        return answer;
    }

    public int[] solution2(String[] id_list, String[] report, int k) {
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> count = new HashMap<>();
        for (String s : list) {
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();
    }
}
