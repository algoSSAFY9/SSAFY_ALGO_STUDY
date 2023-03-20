package week08;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BS9_9461 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n+2];
			arr[0]=1; arr[1]=1; arr[2]=1;
			
			for(int i=3; i<n; i++) {
				arr[i]=arr[i-2]+arr[i-3];
			}
			sb.append(arr[n-1]).append("\n");
		}
		System.out.println(sb);
	}
}
