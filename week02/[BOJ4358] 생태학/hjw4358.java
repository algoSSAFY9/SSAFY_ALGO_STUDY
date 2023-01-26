import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class hjw4358 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String line = "";
		
		Map<String, Integer> map = new HashMap<>();
		ArrayList<String> arr = new ArrayList<>();
		int cnt = 0;
		while((line = br.readLine()) != null) {
			cnt++;
			if(map.containsKey(line)) {
				int c = map.get(line);
				map.replace(line, c+1);
			}
			else {
				map.put(line, 1);
				arr.add(line);
			}
		}
		
		Collections.sort(arr);
		for(int i=0; i<map.size(); i++) {
			sb.append(arr.get(i)).append(" ");
			sb.append(String.format("%.4f" , (float)map.get(arr.get(i)) / cnt * 100) ).append("\n");
		}
		System.out.println(sb.toString());
	}

}
