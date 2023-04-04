import java.io.BufferedReader;
import java.io.InputStreamReader;

public class hjw5525 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String line = br.readLine();
		
		String me = "IOI";
		
		int res = 0, cnt = 0;
		for(int i=0; i<=m-me.length(); i++) {
			if(line.charAt(i) == 'O') continue;
			
			String chk = line.substring(i, i+me.length());
			if(chk.equals(me)) {
				cnt++;
				
				if(cnt == n) {
					cnt--;
					res++;
				}
				i++;
			}
			else cnt = 0;
		}
		
		System.out.println(res);
	}
}
