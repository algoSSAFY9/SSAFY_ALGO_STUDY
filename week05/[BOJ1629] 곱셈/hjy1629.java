import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hjy1629 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int a = Integer.parseInt(st.nextToken());	// 밑
		int b = Integer.parseInt(st.nextToken());	// 지수
		int c = Integer.parseInt(st.nextToken());	// 나눌 수
		
		System.out.println(pow(a,b,c));
	}
	
	public static long pow(int a, int b, int c) {
		if(b == 1) {	// 지수가 1일 경우
			return a % c;
		}
		else if(b%2 == 1) {	// 지수 홀수
			long temp = pow(a,b/2,c);
			return temp*temp%c * a%c;
		}
		else {	// 지수 짝수
			long temp = pow(a,b/2,c);
			return temp * temp % c;	
		}
	}
}
