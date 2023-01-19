import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class hjw1158 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=1; i<=n; i++) {
			arr.add(i);
		}
		
		int cnt = 1, i = 0;
		sb.append("<");
		while(arr.size() > 0) {
			if(i >= arr.size()) i = 0;
			if(cnt == k) {
				if(arr.size() != 1) {
					sb.append(arr.get(i)).append(", ");
				}
				else sb.append(arr.get(i)).append(">");
				arr.remove(i);
				cnt = 1;
			}
			else {
				i++;
				cnt++;
			}
		}
		
		System.out.println(sb.toString());
	}

}