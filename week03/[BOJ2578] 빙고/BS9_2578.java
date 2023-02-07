package algorithm_study.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BS9_2578 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] bing = new int[26][2]; // 입력받은 빙고판 숫자의 i, j 좌표 정보 저장
		int[] col_cnt = new int[5];
		int[] row_cnt = new int[5];
		int leftToR = 0;
		int RightToL = 0;
		int bingGo_cnt = 0;
		
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				bing[Integer.parseInt(st.nextToken())]= new int[]{i,j};
			}
		}
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				int num = Integer.parseInt(st.nextToken());
				int[] tempBing = bing[num];
				if(++col_cnt[tempBing[0]]==5) bingGo_cnt++; // num이 속한 열이 5번 방문되었는지 확인
				if(++row_cnt[tempBing[1]]==5) bingGo_cnt++; // 행
				
				if(tempBing[0]==tempBing[1]) { //좌측상단에서 우측 하단 대각선 확인
					if(++leftToR==5) bingGo_cnt++;
				}
				if(tempBing[0]+tempBing[1]==4) { //우측상단에서 좌측 하단 대각선 확인
					if(++RightToL==5) bingGo_cnt++;
				}

				if(bingGo_cnt>=3) { //전체 빙고 합 확인
					System.out.println(5*i+j+1);
					return;
				}
			}
		}
	}
}


