import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class hjy11723 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		HashSet<Integer> hset = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		int num = 0;
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken(); 

			switch (op) {
			case "add":
				num = Integer.parseInt(st.nextToken());
				hset.add(num);
				break;
			case "remove":
				num = Integer.parseInt(st.nextToken());
				hset.remove(num);
				break;
			case "check":
				num = Integer.parseInt(st.nextToken());
				if(hset.contains(num)) {
					sb.append("1").append("\n");
				}
				else
					sb.append("0").append("\n");
				break;
			case "toggle":
				num = Integer.parseInt(st.nextToken());
				if(hset.contains(num)) {
					hset.remove(num);
				}
				else
					hset.add(num);
				break;
			case "all":
				hset.clear();
				for (int j = 0; j < 21; j++) {
					hset.add(j);
				}
				break;
			case "empty":
				hset.clear();
				break;
			}
		}
		System.out.println(sb);
	}
}
