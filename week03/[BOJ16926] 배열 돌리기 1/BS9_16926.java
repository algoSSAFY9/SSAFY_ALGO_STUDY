package algorithm_study.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BS9_16926 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		String[][] arr = new String[N][];
		for(int i=0; i<N; i++)
			arr[i] = br.readLine().split(" ");
		
		int x, y;
		String temp, temp2;
		
		for(int m=0; m<Math.min(N, M)/2; m++) {
//			R=R%(2*N+2*M-8*m-4); // 이건 왜 안되는건지 모르겠네...
			for(int r=0; r<R; r++) {
				temp=arr[m][m]; // 이전 값
				temp2=null; // 현재 값 (temp)
				
				x = m;
				y = m;
				for(int t=m+1; t<N-m; t++) {
					temp2=arr[++y][x];
					arr[y][x]=temp;
					temp = temp2;
				}
				for(int t=m+1; t<M-m; t++) {
					temp2=arr[y][++x];
					arr[y][x]=temp;
					temp = temp2;
				}
				for(int t=m+1; t<N-m; t++) {
					temp2=arr[--y][x];
					arr[y][x]=temp;
					temp = temp2;
				}
				for(int t=m+1; t<M-m; t++) {
					temp2=arr[y][--x];
					arr[y][x]=temp;
					temp = temp2;
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++)
				sb.append(arr[i][j]).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder sb = new StringBuilder();
//		
//		int[] dx = {0, 1, 0, -1}; // 하, 우, 상, 좌
//		int[] dy = {1, 0, -1,  0};
//		
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		int R = Integer.parseInt(st.nextToken());
//		
//		String[][] arr = new String[N][];
//		for(int i=0; i<N; i++)
//			arr[i] = br.readLine().split(" ");
//		
//		int x, y ,d, cnt;
//		String temp, temp2;
//		
//		for(int m=0; m<Math.min(N, M)/2; m++) {
//			cnt=2*N+2*M-8*m-4;
//			for(int r=0; r<R; r++) {
//				temp=arr[m][m]; // 이전 값
//				temp2=null; // 현재 값 (temp)
//				d=0;
//				x = m;
//				y = m;
//				for(int t=0; t < cnt; t++) {
//					x+=dx[d];
//					y+=dy[d];
//					temp2=arr[y][x];
//					arr[y][x]=temp;
//					temp = temp2;
//
//					switch(d) {
//					case 0: {if(y==N-1-m) d++; break;}
//					case 1: {if(x==M-1-m) d++; break;}
//					case 2: {if(y==0+m) d++; break;}
//					}
//				}
//			}
//		}
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++)
//				sb.append(arr[i][j]).append(" ");
//			sb.append("\n");
//		}
//		System.out.println(sb);
//	}
}
