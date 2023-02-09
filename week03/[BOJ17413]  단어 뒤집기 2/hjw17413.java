import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hjw17413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		StringBuilder res = new StringBuilder();
		for(int i=0; i<line.length(); i++) {
			char ch = line.charAt(i);
			if(ch == '<') {
				if(sb.length() > 0) {
					res.append(sb.reverse());
					sb = new StringBuilder();
				}
				
				res.append(ch);	
				while((ch = line.charAt(++i)) != '>') {
					res.append(ch);	
				}
				res.append(ch);
			}
			else if(ch ==' ') {
				res.append(sb.reverse()).append(" ");
				sb = new StringBuilder();
			}
			else sb.append(ch);
		}
		if(sb.length() > 0) res.append(sb.reverse());
		System.out.println(res.toString());
	}
}
