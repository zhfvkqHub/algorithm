package main.java.programmers.lv2;

// LV2 [3차] 파일명 정렬
public class Solution58 {

    public static void main(String[] args) {
        Solution58 solution57 = new Solution58();
        solution57.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
    }


    class FileName{
        String head;
        String number;
        String tail;
        public FileName(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        @Override
        public String toString() {
            return this.head + this.number + this.tail;
        }
    }


    public String[] solution(String[] files) {
        String[] answer;
        FileName[] fileNames = new FileName[files.length];

        int n = 0, t = 0;
        for(int i = 0; i < files.length; i++) {
            boolean nCheck = false, tCheck = false;
            for(int j = 0; j < files[i].length() - 1; j++) {
                char prev = files[i].charAt(j);
                char next = files[i].charAt(j + 1);

                if(!nCheck && ((prev < '0' || prev > '9') && (next >= '0' && next <= '9'))) {
                    n = j + 1;
                    nCheck = true;
                }
                if(!tCheck && ((prev >= '0' && prev <= '9') && (next < '0' || next > '9'))) {
                    t = j + 1;
                    tCheck = true;
                }
                if(nCheck && tCheck) {
                    break;
                }
            }

            if(!tCheck) {
                t = files[i].length();
                fileNames[i] = new FileName(files[i].substring(0, n), files[i].substring(n, t), "");
            }else {
                fileNames[i] = new FileName(files[i].substring(0, n), files[i].substring(n, t), files[i].substring(t));
            }
        }

        for(int i = 0; i < fileNames.length; i++) {
            for(int j = 1; j < fileNames.length - i; j++) {
                int compare = fileNames[j].head.compareToIgnoreCase(fileNames[j - 1].head);
                
                if(compare == 0) {
                    if(Integer.parseInt(fileNames[j].number) < Integer.parseInt(fileNames[j - 1].number)) {
                        FileName temp = fileNames[j];
                        fileNames[j] = fileNames[j - 1];
                        fileNames[j - 1] = temp;
                    }
                }else if(compare < 0){
                    FileName temp = fileNames[j];
                    fileNames[j] = fileNames[j - 1];
                    fileNames[j - 1] = temp;
                }

            }
        }

        answer = new String[fileNames.length];
        for(int i = 0; i < fileNames.length; i++) {
            answer[i] = fileNames[i].toString();
        }

        return answer;
    }
}


