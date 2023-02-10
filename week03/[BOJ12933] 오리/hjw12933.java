import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hjw12933 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		int cnt = 0;
		int[] res = new int[5];
		
		if(line.length() % 5 != 0) {
			System.out.println(-1);
			return;
		}
		
		for(int i=0; i<line.length(); i++) {
			char ch = line.charAt(i);
			if(ch == 'q') res[0]++;
			else if(ch == 'u') res[1]++;
			else if(ch == 'a') res[2]++;
			else if(ch == 'c') res[3]++;
			else if(ch == 'k') {
				cnt = Math.max(cnt, res[0] - res[4]);
				res[4]++;
			}
			else {
				System.out.print(-1);
				return;
			}
			if(res[0] < res[1] || res[1] < res[2] || res[2] < res[3] || res[3] < res[4]) {
				System.out.print(-1);
				return;
			}
		}
		if((res[0] & res[1] & res[2] & res[3] & res[4]) != 0) {
			System.out.println(cnt);
		}
		else System.out.print(-1);
	}
}
