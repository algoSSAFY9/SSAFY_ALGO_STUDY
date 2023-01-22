import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class hjw1620 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		String[] arrString = new String[n+1];
		HashMap<String, Integer> mapInt = new HashMap<>();
		for(int i=1; i<=n; i++) {
			String line = br.readLine();
			mapInt.put(line, i);
			arrString[i] = line;
		}
		
		for(int i=0; i<m; i++) {
			String guess = br.readLine();
			if(guess.charAt(0) - '0' >= 10) {//string
				sb.append(mapInt.get(guess));
			}
			else { //숫자
				sb.append(arrString[Integer.parseInt(guess)]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
