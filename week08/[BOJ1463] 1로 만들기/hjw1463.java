import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class hjw1463 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(cal(N));
	}
	
	static int cal(int N) {
		Queue<int[] > q = new LinkedList<>();
		q.add(new int[] {N, 0});
		
		int res = 0;
		while(!q.isEmpty()) {
			int[] num = q.poll();
			int nm = num[0], cnt = num[1];
			
			if(nm == 1) {
				res = cnt;
				break;
			}
			
			if(nm < 1) continue;
			
			if(nm % 3 == 0) q.add(new int[] {nm / 3, cnt + 1});
			if(nm % 2 == 0) q.add(new int[] {nm / 2, cnt + 1});
			q.add(new int[] {nm - 1, cnt + 1});
		}
		
		return res;
	}
}
