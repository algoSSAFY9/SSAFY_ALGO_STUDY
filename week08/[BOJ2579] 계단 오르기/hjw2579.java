import java.io.BufferedReader;
import java.io.InputStreamReader;

public class hjw2579 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		
		for(int n=1; n<=N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[N+1];
		dp[0] = 0;
		dp[1] = arr[1];
		if(N >= 2) {
			dp[2] = arr[2] + dp[1];
		}
		for(int i=3; i<=N; i++) {
			dp[i] = Math.max(dp[i-3] + arr[i-1], dp[i-2]) + arr[i];
		}
		
		System.out.println(dp[N]);
	}

}
