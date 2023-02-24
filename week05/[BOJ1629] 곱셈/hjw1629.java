import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hjw1629 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken()); // 횟수
		int c = Integer.parseInt(st.nextToken()); // 나누는 값
		
		System.out.println(cal(a, b, c));
	}
	
	static long cal(int a, long b, int c) {
		if(b == 1) return a % c;
		
		long temp = cal(a, b / 2, c);
		
		if( b % 2 == 0 ) return temp * temp % c;
		else return (temp * temp % c) * a % c;
	}
}
