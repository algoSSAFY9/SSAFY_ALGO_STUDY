import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class hjw1697 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		if(n == m) {
			System.out.println(0);
		}
		else bfs(n, m);
	}
	
	static void bfs(int n, int k) {
		int[] dx = {-1, 1};
		
		boolean[] check = new boolean[100_001];
		check[n] = true;
		Queue<int[] > q = new LinkedList<>();
		q.add(new int[] {n, 0});
		while(!q.isEmpty()) {
			int[] pol = q.poll();
			
			for(int i=0; i<3; i++) {
				int x = pol[0];
				int nx = 0;
				if(i == 2) nx = x * 2;
				else nx = x + dx[i];
				
				if(nx < 0 || nx > 100_000 || check[nx]) continue;
				if(nx == k) {
					System.out.println(pol[1] + 1);
					return;
				}
				check[nx] = true;
				q.add(new int[] {nx, pol[1] + 1});
			}
		}
	}
}
