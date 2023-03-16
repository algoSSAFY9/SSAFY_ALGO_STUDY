import java.io.BufferedReader;
import java.io.InputStreamReader;

public class hjw9095 {
	static int N, cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			cnt = 0;
			cal(0);
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void cal(int res) {
		if(res == N) {
			cnt++;
			return;
		}
		else if( res > N ) return;
		
		for(int i=1; i<=3; i++) {
			res += i;
			cal(res);
			res -= i;
		}
	}
}
