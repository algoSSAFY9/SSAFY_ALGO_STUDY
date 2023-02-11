package algorithm_study.구현;

import java.io.*;
import java.util.*;

/*
 * 오목
 * 딱 다섯 알이 연속이면 승리
 * 검은 알 - 1
 * 흰 알	- 2
 * 빈자리  - 0
 * 
 * 검은색 승리 - 1출력
 * 흰색 승리 - 2출력
 * 승부 결정안남 - 0출력
 */
public class BS2_2615 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dx= {1, 1, 0,  1}; // → ↘ ↓ ↗
		int[] dy= {0, 1, 1, -1};
		
		char [][] pan = new char[19][19];
		
		StringTokenizer st;
		for(int i=0; i<19; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<19; j++)
				pan[i][j] = st.nextToken().charAt(0);
		}
		
		int x, y;
		char cur;
		boolean flag;
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				cur=pan[i][j];
				if(cur=='0') continue;
				for(int d=0; d<4; d++) {
					if((d==0 || d==1 || d==3) & j>14) continue;
					else if(d==2 & i>14) continue;
					
					flag=false; // 초기화
					x=j-dx[d];
					y=i-dy[d];
					if(x>=0 && y>=0 && y<19 && pan[y][x]==cur) // x는 오른쪽으로 넘어가는 경우가 없음.
						continue;
					
					x=j+dx[d]*5;
					y=i+dy[d]*5;
					if(x<19 && y>=0 && y<19 && cur==pan[y][x])
						continue;
					
					
					for(int m=1; m<5; m++) { // 다음 4개 확인
						x=j+dx[d]*m;
						y=i+dy[d]*m;
						if(x>=19 || y<0 || y>=19 || cur!=pan[y][x]) {
							flag=true;
							break;
						}
					}
					
					if(!flag) {
						System.out.println(cur);
						System.out.println((i+1) + " " + (j+1));
						return;
					}
				}
			}
		}
		System.out.println(0);
	}
}