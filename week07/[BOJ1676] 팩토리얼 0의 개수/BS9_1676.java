package algorithm_study.week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BS9_1676 {

	static int ans=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			dfs(i);
		}
		System.out.println(ans);
	}

	static void dfs(int n) {
		if(n%5==0) {
			ans++;
			dfs(n/5);
		}
	}
}
