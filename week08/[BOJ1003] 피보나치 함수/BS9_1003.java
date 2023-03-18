package algorithm_study.week8;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BS9_1003 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for(int c=0; c<N; c++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[n+3][2]; // n이 0또는 1인경우에 index 범위를 벗어나지 않게 하기위함.
			arr[0]= new int[] {1, 0};
			arr[1]= new int[] {0, 1};
			for(int i=2; i<=n; i++) {
				arr[i]=new int[] {arr[i-2][0]+arr[i-1][0], arr[i-2][1]+arr[i-1][1]};
			}
			
			sb.append(arr[n][0]).append(' ').append(arr[n][1]).append("\n");
		}
		System.out.println(sb);
	}
}
