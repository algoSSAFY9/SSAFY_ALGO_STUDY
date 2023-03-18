package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class kej9375 {
	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		HashMap<String, Integer> map = new HashMap<>();
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			for(int i  =0;i<n;i++) {
				st = new StringTokenizer(br.readLine()," ");
				String s1 = st.nextToken();
				String s2 = st.nextToken();
				if(!map.containsKey(s2)) {	// 옷 종류가 없으면 value 1해서 넣어주기 
					map.put(s2, 1);
				} else {
					map.put(s2,map.get(s2)+1); // 있으면 key값 찾아서 value + 1
				}
			}
			// 옷을 입거나 안입거나,,,
			int cnt = 1;
			
			for(Entry<String,Integer> entrySet : map.entrySet()) {
				cnt *= entrySet.getValue()+1;	// 옷 가지 수에서 안입는 경우 포함해야 하니까 +
			}
			sb.append(cnt-1).append("\n");	// 다 안입었을 경우 빼기 
			map.clear();	// map 초기화 
		}
		System.out.println(sb);
	}

}
