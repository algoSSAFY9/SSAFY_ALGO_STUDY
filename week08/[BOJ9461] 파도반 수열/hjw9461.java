import java.io.BufferedReader;
import java.io.InputStreamReader;

public class hjw9461 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		long[] dp = new long[101];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		for(int i=3; i<=100; i++) {
			dp[i] = dp[i-2] + dp[i-3];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<T; t++) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
