import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hjy1541 {
	public static void main(String[] args) throws IOException {
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int sum = Integer.MAX_VALUE;
		
		// "-"을 기준으로 나눔
		StringTokenizer minus = new StringTokenizer(br.readLine(), "-");	
 
		while (minus.hasMoreTokens()) {
			int add_rst = 0;
 
			// "-"을 기준으로 나눈 토큰을 "+"를 기준으로 다시 나눔
			StringTokenizer add = new StringTokenizer(minus.nextToken(), "+");
			
			// "+"으로 나뉜 토큰 더함 
			while (add.hasMoreTokens()) {
				add_rst += Integer.parseInt(add.nextToken());
			}
			
			// 해당 토큰이 처음인 경우  : temp 값이 처음 값 됨
			if (sum == Integer.MAX_VALUE) {
				sum = add_rst;
			} 
			// 계산된 add_rst 값을 sum에서 빼줌
			else {
				sum -= add_rst;
			}
		}
		System.out.println(sum);
	}
}
