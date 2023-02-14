import java.io.BufferedReader;
import java.io.InputStreamReader;

public class kbs1436 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int i = 666;
		int cnt = 0;
		while (true) {
			if (Integer.toString(i).contains("666")) {
				cnt++;
			}
			if (cnt == n)
				break;
			i++;
		}
		System.out.println(i);
	}
}
