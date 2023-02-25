import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hjw14888 {
	static int[] arr, calc;
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		calc = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			calc[i] = Integer.parseInt(st.nextToken());
		}
		cal(0, arr[0]);
		System.out.println(max);
		System.out.println(min);
	}
	
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static void cal(int depth, int res) {
		if(depth == n - 1) {
			max = Math.max(max, res);
			min = Math.min(min, res);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(calc[i] > 0) {
				calc[i]--;
				if(i == 0) cal(depth+1, res + arr[depth+1]);
				else if(i == 1) cal(depth+1, res - arr[depth+1]);
				else if(i == 2) cal(depth+1, res * arr[depth+1]);
				else if(i == 3) cal(depth+1, res / arr[depth+1]);
				calc[i]++;
			}
		}
	}
}
