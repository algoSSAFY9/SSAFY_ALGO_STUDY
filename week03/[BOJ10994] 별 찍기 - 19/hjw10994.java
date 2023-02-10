import java.io.BufferedReader;
import java.io.InputStreamReader;

public class hjw10994 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int start = 0, end = 1 + 4*(n-1);
		
		String[][] ch = new String[end][end];
		end--;
		while(start <= end) {
			for(int i=start; i<=end; i++) {
				if(end % 2 == 0) ch[start][i] = "*";
				else ch[start][i] = " ";
			}
			for(int i=start+1; i<=end; i++) {
				if(end % 2 == 0) ch[i][end] = "*";
				else ch[i][end] = " ";
			}
			for(int i=end-1; i>=start; i--) {
				if(end % 2 == 0) ch[end][i] = "*";
				else ch[end][i] = " ";
			}
			for(int i=end-1; i>=start; i--) {
				if(end % 2 == 0) ch[i][start] = "*";
				else ch[i][start] = " ";
			}
			start++; end--;
		}
		
		for(int i=0; i<ch.length; i++) {
			for(int j=0; j<ch[0].length; j++) {
				sb.append(ch[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
