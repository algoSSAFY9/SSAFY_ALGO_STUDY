package algorithm_study.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 배열 돌리기
 * 주 대각선 / 가운데 열 / 부 대각선 / 가운데 행을 회전
 * Arrays.copyOf가 System.arraycopy보다 두 배정도 빠르다고 함.
 */
public class BS9_17276 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int n, degree;
		
		String[][] arr;
		String[][] res;
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			degree = Integer.parseInt(st.nextToken());
			if(degree<0) degree+=360;
			degree=(degree*8)/360;
			
			arr=new String[n][n]; // 배열 입력
			res=new String[n][n];
			for(int i=0; i<n; i++) {
				String[] nums = br.readLine().split(" ");
				arr[i]=nums;
				res[i]=Arrays.copyOf(nums, n);
			}
			
			for(int i=0; i<n; i++) {
				for(int d=0; d<4; d++) {
					String temp = null;
					switch (d) {
					case 0: {temp=arr[i][i]; break;}
					case 1: {temp=arr[i][n/2]; break;}
					case 2: {temp=arr[i][n-i-1]; break;}
					case 3: {temp=arr[n/2][n-i-1]; break;}
					}
					
					switch((degree+d)%8) {
					case 0:{res[i][i]=temp; break;}
					case 1:{res[i][n/2]=temp; break;}
					case 2:{res[i][n-i-1]=temp; break;}
					case 3:{res[n/2][n-i-1]=temp; break;}
					case 4:{res[n-i-1][n-i-1]=temp; break;}
					case 5:{res[n-i-1][n/2]=temp; break;}
					case 6:{res[n-i-1][i]=temp; break;}
					case 7:{res[n/2][i]=temp; break;}
					}
				}
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++)
					sb.append(res[i][j]).append(" ");
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
