import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class hjw2075 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n*n];
		
		StringTokenizer st;
		int x = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[x++] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(arr);
		
		System.out.println(arr[n*n-n]);
	}

}
