package algorithm_study.week8;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BS9_9095 {

	static int n, cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			n = Integer.parseInt(br.readLine());
			cnt=0;
			
			dfs(0);
			
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int sum) {
		if(sum>n) return;
		if(sum==n) {
			cnt++;
			return;
		}
		for(int i=1; i<=3; i++) dfs(sum+i);
	}
}
