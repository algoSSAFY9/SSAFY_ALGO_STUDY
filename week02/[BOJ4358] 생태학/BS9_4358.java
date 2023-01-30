package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BS9_4358 {

	public static void main(String[] args) throws IOException {
		Map<String, Integer> set = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str;
		int cnt=0;
		while((str=br.readLine())!=null && !str.equals("")) {
			cnt++;
			if(set.containsKey(str)) set.put(str, set.get(str)+1);
			else set.put(str, 1);
		}
		List<String> keyList = new ArrayList<>(set.keySet());
		keyList.sort((s1, s2) -> s1.compareTo(s2));
		for(String key : keyList) {
			sb.append(key+" "+String.format("%.4f\n", 100.0*set.get(key)/cnt));
		}
		System.out.println(sb);
		br.close();
	}
}
