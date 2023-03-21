import java.io.BufferedReader;
import java.io.InputStreamReader;

public class kbs11726 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long[] arr = new long[n+1];
		arr[1] = 1;
		arr[2] = 2;
		for(int i=3;i<n+1;i++) {
			arr[i] = (arr[i-1]+arr[i-2])%10007;
		}
		
		System.out.println(arr[n]);
	}
}
