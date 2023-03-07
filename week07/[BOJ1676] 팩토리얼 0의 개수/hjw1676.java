import java.io.BufferedReader;
import java.io.InputStreamReader;

public class hjw1676 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int res = 0;
		res += N / 5 + N / 25 + N / 125;
		System.out.println(res);
	}
}
