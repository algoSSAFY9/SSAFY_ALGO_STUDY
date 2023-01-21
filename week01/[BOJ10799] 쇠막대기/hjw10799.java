import java.io.BufferedReader;
import java.io.InputStreamReader;

public class hjw10799 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String Line = br.readLine();
		
		int res = 0, mid = 0;
		for(int i=0; i<Line.length(); i++) {
			char ch = Line.charAt(i);
			if(ch == '(') {
				if(Line.charAt(i+1) == ')') {
					res += mid;
					i++;
				}
				else {
					mid++;
					res += mid;
				}
			}
			else {
				mid--;
				res -= mid;
			}
			
		}
		System.out.println(res);
	}

}
