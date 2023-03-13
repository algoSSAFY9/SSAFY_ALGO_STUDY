import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class hjy11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		HashSet<Integer> hset = new HashSet<>();
		int n = 0;
		
		for (int i = 0; i < N; i++) {
			n = Integer.parseInt(br.readLine());
			hset.add(n);
		}
		
		ArrayList<Integer> list = new ArrayList<>(hset);
		Collections.sort(list);
		
		for (int i = list.size()-1; i >= 0; i--) {
			if(list.get(i) <= K) {
				cnt += K/list.get(i);
				K %= list.get(i);
			}
			else
				continue;	
		}
		System.out.println(cnt);
	}
}