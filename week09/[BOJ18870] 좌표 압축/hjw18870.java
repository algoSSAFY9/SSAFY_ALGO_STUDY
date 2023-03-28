import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class hjw18870 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> hm = new HashMap<>();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			hm.put(arr[i], 0);
		}
		
		Object[] obj = hm.keySet().toArray();
		int idx = 0;
		Arrays.sort(obj);
		for(Object key : obj) {
			hm.replace((Integer) key, idx++);
		}

		StringBuilder sb = new StringBuilder();
		for(int x : arr) {
			sb.append(hm.get(x)).append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
