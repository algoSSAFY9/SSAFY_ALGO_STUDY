import java.io.BufferedReader;
import java.io.InputStreamReader;

public class hjw1463_recur {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(cal(N, 0));
	}
	
	static int cal(int N, int cnt) {
		if(N < 2) return cnt;
		return Math.min(cal(N/2, (cnt+1) + (N % 2)), cal(N/3, (cnt+1) + (N % 3)));
	}
}
