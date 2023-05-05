package main.java.programmers.lv3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 아이템 줍기
 * https://school.programmers.co.kr/learn/courses/30/lessons/87694?language=java
 */
public class Solution17 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visited;
    static int cX, cY, iX, iY;
    static int[][] rectangleCopy;
    static int[][] map;
    static class Node{
        int row;
        int col;
        int count;
        Node(int row, int col, int count){
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }

    public static int bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(cY, cX, 0));
        visited = new boolean[102][102];
        visited[cY][cX] = true;

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.row == iY && temp.col == iX){
                return temp.count;
            }
            for(int i = 0; i < 4; i++){
                int nextRow = temp.row + dy[i];
                int nextCol = temp.col + dx[i];

                if(nextRow < 0 || nextRow >= 102 || nextCol < 0 || nextCol >= 102)
                    continue;

                if(visited[nextRow][nextCol] == true || map[nextRow][nextCol] == 1 || map[nextRow][nextCol] == 0)
                    continue;


                visited[nextRow][nextCol] = true;
                queue.add(new Node(nextRow, nextCol, temp.count + 1));

            }
        }
        return 0;
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer;
        rectangleCopy = rectangle;
        cX = characterX * 2;
        cY = characterY * 2;
        iX = itemX * 2;
        iY = itemY * 2;

        map = new int[102][102];
        for(int i = 1; i < 102; i++){
            for(int j = 1; j < 102 ; j++){
                map[i][j] = 1;
            }
        }


        for(int i = 0; i < rectangleCopy.length; i++){
            int rec1Y = rectangleCopy[i][1] * 2;
            int rec1X = rectangleCopy[i][0] * 2;
            int rec2Y = rectangleCopy[i][3] * 2;
            int rec2X = rectangleCopy[i][2] * 2;

            for(int j = rec1Y; j <= rec2Y; j++){
                for(int k = rec1X; k <= rec2X; k++){
                    if((map[j][k] == 1|| map[j][k] == 2) && (j == rec1Y || j == rec2Y))
                        map[j][k] = 2;
                    else if( (map[j][k] == 1|| map[j][k] == 2) && (k == rec1X || k == rec2X))
                        map[j][k] = 2;
                    else
                        map[j][k] = 0;
                }
            }
        }

        answer = bfs() / 2;
        return answer;
    }

}



