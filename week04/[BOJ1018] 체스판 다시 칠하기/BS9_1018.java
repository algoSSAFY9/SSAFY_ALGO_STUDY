package algorithm_study.브루트포스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 체스판 다시 칠하기
 * MxN 크기의 보드 -> MN개의 정사각형으로 이루어져있음.
 * 
 * 8*8크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해 체스판을 만든다
 * 다시 칠해야하는 정사각형의 최소 개수
 * 
 * 즉, 다시 칠해야하는 정사각형의 개수가 가장 작은 8*8구간을 찾아야함.
 */
public class BS9_1018 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[N][];
		
		for(int i=0; i<N; i++) {
			arr[i]=br.readLine().toCharArray();
		}
		
		int cnt, min=64;
		char norm;
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				norm = arr[i][j];
				cnt=0;
				for(int y=i; y<i+8; y++) {
					for(int x=j; x<j+8; x++) {
						if((x+y)%2==0) {
							if(arr[y][x]!=norm) cnt++;
						}
						else if(arr[y][x]==norm) cnt++;
					}
				}
				if(cnt>=32) cnt=64-cnt;
				min=Math.min(min, cnt);
			}
		}
		System.out.println(min);
	}
}


