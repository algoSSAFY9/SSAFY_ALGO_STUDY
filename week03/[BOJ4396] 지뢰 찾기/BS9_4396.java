package algorithm_study.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 지뢰 찾기
/*
 *  n*n 격자
 *  m 개의 지뢰
 *  지뢰 터치 -> player lose
 *  no 지뢰 터치 -> 터치 지점의 상화좌우 혹은 대각선으로 인접한 8개 칸에 
 *  			지뢰가 몇 개 있는지 알려주는 0~8사이의 수 나타남
 *  빈 칸 == 0
 *  일부 플레이된 게임의 정보를 읽어 해당하는 격자를 출력하는 것
 *  
 *  [입력]
 *  * == 지뢰 / . == 지뢰X
 *  x == 열린 칸 / . == 열리지 않은 칸
 *  
 *  [출력]
 *  지뢰가 없는 열린 칸은 0과 8사이 숫자 출력
 *  지뢰가 있는 칸이 열렸다면 지뢰가 있는 모든 칸이 *로 표시
 *  다른 지점은 모두 .
 */

public class BS9_4396 {
	
	static int[][] delta = {{-1, -1, 0, 1, 1,  1,  0, -1},  //y
							{ 0,  1, 1, 1, 0, -1, -1, -1}}; //x
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] bomb = new int[N+2][N+2];
		char[][] user = new char[N][];
		
		boolean Booom = false;
		
		int temp_cnt=0;
		
		for(int i=1; i<=N; i++) { // 지뢰밭 입력
			String bomb_line = br.readLine();
			for(int j=1; j<=N; j++) {
				if(bomb_line.charAt(j-1)=='.') bomb[i][j]=0;
				else bomb[i][j]=1;
			}
		}
		for(int i=0; i<N; i++) { // 유저 진행 화면 입력
			user[i]=br.readLine().toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				if(user[i][j]=='x') {
					if(bomb[i+1][j+1]!=1) {
						// 핵심 - 8방향 지뢰 검출
						temp_cnt=0;
						
						for(int d=0; d<8; d++) {
							int dy = i+1+delta[0][d]; // bomb이차원 배열보다 바운더리가 하나 작아서 1 더해줌.
							int dx = j+1+delta[1][d];
							
							temp_cnt+=bomb[dy][dx];
						}
						
						user[i][j]=(char)(temp_cnt+'0');
					}
					else Booom=true;
				}
			}
		}
		if(Booom) {
			for(int i = 1; i<N+2; i++) {
				for(int j=1; j<N+2; j++) {
					if(bomb[i][j]==1) user[i-1][j-1]='*';
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(char[] c:user) {
			sb.append(c);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
