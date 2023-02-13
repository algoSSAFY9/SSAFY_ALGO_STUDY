import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class kbs20291 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> hm = new HashMap<>();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			String tmp = str.substring(str.indexOf('.') + 1);
			if (hm.get(tmp) != null)
				hm.put(tmp, hm.get(tmp) + 1);
			else
				hm.put(tmp, 1);
		}
		// sort
		// 1. TreeMap 이용
		Map<String, Integer> sortedMap = new TreeMap<>(hm);
		// 2. Collections 이용
//		List<String> sortL = new ArrayList<>(hm.keySet());
//		Collections.sort(sortL);

		// output
		StringBuilder sb = new StringBuilder();

		// TreeMap일 때
		sortedMap.forEach((key, value) -> {
			sb.append(key + " " + value).append("\n");
		});
		// Collections일때
//		for (String k : sortL) {
//			System.out.print(k);
//			System.out.println(" " + hm.get(k));
//		}

		System.out.println(sb);
	}
}
