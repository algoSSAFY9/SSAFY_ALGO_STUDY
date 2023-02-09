package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class kej20291 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String,Integer> map = new TreeMap<>();		// 들어오면 key값에 따라 바로 정렬하려고 TreeMap 사용!
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine(),".");	//.을 기준으로 문자열 분리
			String s = st.nextToken();
			String key = st.nextToken();	// 이것만 있음 됨!
			if(!map.containsKey(key)) map.put(key, 1);
			else {
				map.replace(key, map.get(key)+1);
			}	
		}
		StringBuilder sb = new StringBuilder();
		map.forEach((key,value)->{
			sb.append(key).append(" ").append(value).append("\n");
		});
		
		System.out.println(sb);
		
		
	}

}
