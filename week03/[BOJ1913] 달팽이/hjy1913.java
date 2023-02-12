package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hjy1913 {

	public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());	// 줄의 수
        int num = Integer.parseInt(br.readLine());	// 찾고자 하는 수
        int[][] rst = new int[N][N];	// 배열
        int cnt;
        int max;
        int line_cnt;
         
        int row = -1;
        int col = 0;
        int trans = 1;

        max = N*N;
        line_cnt = N;
        cnt = N*N;
        while(cnt >= 1) {
            for(int i = 0; i < line_cnt; i++) {
                row += trans;
                rst[row][col] = cnt;
                cnt--;
            }
            line_cnt--;
            for(int i = 0; i < line_cnt; i++) {
                col += trans;
                rst[row][col] = cnt;
                cnt--;
            }
            trans *= -1;
        }
        int[] find_idx = new int[2];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(rst[i][j]).append(" ");
                if(rst[i][j] == num) {
                	find_idx[0] = i+1;
                	find_idx[1] = j+1;
                }
            }
            sb.append("\n");
        }
        sb.append(find_idx[0] +" ").append(find_idx[1]+"");
        System.out.print(sb);
    }
}
