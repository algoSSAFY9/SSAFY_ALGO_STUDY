import java.io.BufferedReader;
import java.io.InputStreamReader;

public class hjw2231 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int min = Integer.MAX_VALUE;
		for(int i=n-1; i > 0; i--) {
			int x = i, res = i; 
			int plus = 10; 
			while(plus > 0) {
				res += x % plus;
				if( x / plus == 0) break;
				x /= plus;
			}
			if(res == n) min = Math.min(min, i);
		}
		
		System.out.println(min == Integer.MAX_VALUE ? 0 : min);
	}

}
