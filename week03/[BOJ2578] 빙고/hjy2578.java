package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class hjy2578 {
    
    public static void main(String[] args) throws IOException {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String[] str;
    	int[][] bingo = new int[5][5];	// 빙고판
        Queue<Integer> call_num = new LinkedList<>();	// 사회자 부른 번호들
        int line_cnt = 0;	// 맞춘 라인 수

        // 빙고판 입력
        for(int i = 0; i < 5; i++) {
        	str = br.readLine().split(" ");
            for(int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(str[j]);
            }
        }
        
        // 사회자 번호 입력
        for(int i = 0; i < 5; i++) {
        	str = br.readLine().split(" ");
            for(int j = 0; j < 5; j++) {
            	call_num.offer(Integer.parseInt(str[j]));
            }
        }
        
        int call_cnt = 0; 
        int zero_cnt = 0;
        while(call_cnt <= 25){
            int num = call_num.poll();

            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if(bingo[i][j] == num) // 사회자가 부른 숫자와 같다면 0으로 바꾸기
                        bingo[i][j] = 0;
                }
            }
            call_cnt++;
            
            // 행 체크
            for(int i = 0; i < 5; i++) {
                zero_cnt = 0;
                for(int j = 0; j < 5; j++) {
                    if(bingo[i][j] == 0)
                    	zero_cnt++;
                }
                if(zero_cnt == 5)
                    line_cnt++;
            }
            // 열 체크
            for(int i = 0; i < 5; i++) {
                zero_cnt = 0;
                for(int j = 0; j < 5; j++) {
                    if(bingo[j][i] == 0)
                    	zero_cnt++;
                }
                if(zero_cnt == 5)
                    line_cnt++;
            }
            // 왼쪽에서 오른쪽 대각선 체크
            zero_cnt = 0;
            for(int i = 0; i < 5; i++) {
                if(bingo[i][i] == 0)
                	zero_cnt++;
            }
            if(zero_cnt == 5)
                line_cnt++;
            // 오른쪽에서 왼쪽 대각선 체크
            zero_cnt = 0;
            for(int i = 0; i < 5; i++) {
                if(bingo[i][4-i] == 0)
                	zero_cnt++;
            }
            if(zero_cnt == 5)
                line_cnt++;

            if(line_cnt >= 3) { // 3줄 이상 빙고이면 몇 번째 숫자인지 출력하고 종료
                System.out.println(call_cnt);
                break;
            }
            line_cnt = 0;
        }
    }


}
