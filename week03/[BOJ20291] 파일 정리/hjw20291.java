import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class hjw20291 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		TreeMap<String, Integer> map = new TreeMap<>();
		for(int i=0; i<n; i++) {
			String[] line = br.readLine().split("\\.");
			map.put(line[1], map.getOrDefault(line[1], 0)+1);
		}
		
		int size = map.size();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<size; i++) {
			sb.append(map.firstKey()).append(" ").append(map.get(map.firstKey())).append("\n");
			map.pollFirstEntry();
		}
		System.out.println(sb.toString());
	}

}
