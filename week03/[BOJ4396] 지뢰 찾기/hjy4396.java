package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hjy4396 {
	
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        char [][] in_list = new char[n][n];	// 지뢰 위치
        char [][] rst = new char[n][n];
        // 주위 8칸 검사
        int [] check_r = {-1, -1, -1, 0, 0, 1, 1, 1};
        int [] check_c = {-1, 0, 1, 1, -1, -1, 0, 1};
        boolean bomb = false;
		
        // 지뢰 위치 입력 받기
        for(int i = 0; i < n ; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++) {
            	in_list[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < n ; i++){
            String check = br.readLine();
            for(int j = 0; j < n; j++) {
            	// 이미 누른 부분 : 주위 지뢰 갯수 or 지뢰 표시
                if(check.charAt(j) == 'x') { 
                	// 지뢰를 눌렀을 경우
                    if(in_list[i][j] == '*') { // 출력시 지뢰 부분을 *로 바꾸기 위한 표시
                    	bomb = true;
                    }
                    // 지뢰를 누르지 않았을 경우
                    else { 
                        int cnt = 0; // 지뢰 갯수
                        // 해당 칸을 둘러싼 8칸 check
                        for (int k = 0; k < 8; k++) { 
                            int r = i + check_r[k];
                            int c = j + check_c[k];
                            // 주위에 지뢰 있으면 cnt 1 증가  ** in_list[r][c]가 입력 범위 속에 존재
                            if (r >= 0 && r < n && c >= 0 && c < n && in_list[r][c] == '*')
                            	cnt++;
                        }
                        rst[i][j] = (char) (cnt + '0');
                    }
                }
                // 아직 누르지 않을 부분 : '.'
                else {
                	rst[i][j] = '.';
                }
            }
        }

        // 지뢰 눌렀을 경우 : 결과값에서 모든 지뢰 위치 *로 표시
        if(bomb) { 
            for(int i = 0; i < n ; i++){
                for(int j = 0; j < n; j++) {
                    if(in_list[i][j] == '*')
                    	rst[i][j] = '*';
                }
            }
        }

        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++) {
            	sb.append(rst[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
