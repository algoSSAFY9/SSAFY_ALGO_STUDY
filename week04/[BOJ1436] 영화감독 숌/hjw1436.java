import java.io.BufferedReader;
import java.io.InputStreamReader;

public class hjw1436 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int res = 666, cnt = 0;
		while(cnt < n) {
			if(String.valueOf(res).contains("666")) {
				cnt++;
			}
			res++;
		}
		System.out.println(res-1);
	}
}
