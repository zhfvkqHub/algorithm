package main.java.v2.programmers.etc;

import java.util.HashSet;
import java.util.Set;

/**
 * [Jabda]
 */
class J20260318_2Java {

    public int solution(String[] files) {
        int count = 0;
        int totalSize = 0;
        Set<String> allowedExtensions = Set.of("pdf", "jpg", "png");
        Set<String> uploadedFileNames = new HashSet<>();

        for (String file : files) {
            String[] parts = file.split(" ");
            String fileName = parts[0];
            int fileSize = Integer.parseInt(parts[1]);
            String extension = parts[2];

            if (allowedExtensions.contains(extension)
                    && totalSize + fileSize <= 1000
                    && !uploadedFileNames.contains(fileName)
            ) {
                count++;
                totalSize += fileSize;
                uploadedFileNames.add(fileName);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // 파일 업로드 시스템에서 업로드 가능한 파일만 골라내려고 한다.
        // 각 파일 정보는 "파일명 크기 확장자" 형식의 문자열로 주어진다.
        // ["report 500 pdf", "image 300 jpg", "music 700 mp3"]
        // 업로드 가능한 확장자는 다음 3개뿐이다. pdf,jpg,png
        // 입력으로 파일 목록이 주어질 때, 업로드 가능한 파일의 개수를 반환하라.

        // 추가 요구사항
        // 전체 업로드 가능한 파일들의 크기 합이 1000 이하여야만 업로드 가능
        // 파일은 입력 순서대로 검사한다. 어떤 파일을 추가했을 때 총 용량이 1000을 초과하면, 그 파일은 업로드 불가
        // 이후 파일은 계속 검사한다.

        // 추가 요구사항
        // 같은 파일명은 중복 업로드 불가

        J20260318_2Java solution = new J20260318_2Java();
        String[] records = {"report 500 pdf", "image 300 jpg", "music 700 mp3"};
        System.out.println(solution.solution(records));
        String[] records2 = {"report 500 pdf", "report 200 jpg", "image 300 jpg", "doc 400 pdf"};
        System.out.println(solution.solution(records2));
    }
}
