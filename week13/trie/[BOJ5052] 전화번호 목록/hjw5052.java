import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class hjw5052 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			String[] arr = new String[N];
			for(int i=0; i<N; i++) {
				arr[i] = br.readLine();
			}
			
			Arrays.sort(arr);
			
			boolean chk = false;
			for(int i=1; i<arr.length; i++) {
				if(arr[i].startsWith(arr[i-1])) {
					chk = true;
					break;
				}
			}
			sb.append(chk ? "NO" : "YES").append("\n");
		}
		System.out.println(sb.toString());
	}

}
