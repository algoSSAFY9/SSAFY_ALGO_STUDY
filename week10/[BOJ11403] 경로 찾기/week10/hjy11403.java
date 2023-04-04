package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hjy11403 {
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        
        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }


        for (int k = 0;k < n; k++) { // 확인할 노드
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    // 갈 수 있는 경로가 있는지만 체크 : 있을 경우 1로 변경
                    if (map[r][k] == 1 && map[k][c] == 1) {
                        map[r][c] = 1;
                    }
                }
            }
        }
        
        
        for (int r = 0; r < n; r++) {
            for (int c = 0;c < n; c++) {
                sb.append(map[r][c]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
