package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 속도가 빠른 순서 : 배열->set->map map이 제일 빠름
public class BS9_14425_ans {

//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		
//		Set<String> set = new HashSet<>();
//		int cnt=0;
//		
//		for(int i=0; i<N; i++) {
//			set.add(br.readLine());
//		}
//		
//		for(int i=0; i<M; i++) {
//			if(set.contains(br.readLine())) cnt++;
//		}
//		System.out.println(cnt);
//	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> set = new HashMap<>();
		int cnt=0;
		
		for(int i=0; i<N; i++) {
			set.put(br.readLine(), 0);
		}
		
		for(int i=0; i<M; i++) {
			if(set.containsKey(br.readLine())) cnt++;
		}
		System.out.println(cnt);
	}
}
