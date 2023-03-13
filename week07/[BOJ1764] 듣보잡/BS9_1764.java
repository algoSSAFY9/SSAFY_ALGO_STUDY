package algorithm_study.week7;

import java.io.*;
import java.util.*;

public class BS9_1764 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			map.put(br.readLine(), 1);
		}
		
		List<String> list = new ArrayList<>();
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			if(map.containsKey(str)) list.add(str);
		}
		
		Collections.sort(list);
		sb.append(list.size()).append("\n");
		for(int i=0; i<list.size(); i++) sb.append(list.get(i)).append("\n");
		
		System.out.println(sb);
		
	}
}
