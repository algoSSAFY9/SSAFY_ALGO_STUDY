import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class hjw15787 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] str = new int[n+1][21];
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken());
			int seat = Integer.parseInt(st.nextToken());
			set.add(seat);
			if (num == 1) {
				int ng = Integer.parseInt(st.nextToken());
				if(str[seat][ng] == 0) {
					str[seat][ng] = 1;
				}
				
			} else if (num == 2) {
				int ng = Integer.parseInt(st.nextToken());
				str[seat][ng] = 0;
			} else if (num == 3) {
				for(int j=20; j>0; j--) {
					str[seat][j] = str[seat][j-1];
				}
			} else if (num == 4) {
				for(int j=1; j<20; j++) {
					str[seat][j] = str[seat][j+1];
				}
			}
		}
		
		HashSet<String> res = new HashSet<>();
		for(int x : set) {
			String ans = "";
			for(int i : str[x]) {
				ans += i;
			}
			ans = ans.substring(1, ans.length());
			res.add(ans);
		}
		
		int chk = 0;
		if((n - set.size()) > 0) chk++;
		System.out.println(res.size() + chk);
	}

}
