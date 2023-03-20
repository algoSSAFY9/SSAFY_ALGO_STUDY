import java.io.*;
import java.util.*;

public class hjw16928 {
	static HashMap<Integer, Integer> bam;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		bam = new HashMap<>();
		for(int i=0; i<n+m; i++) { 
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			bam.put(x, y);
		}

		System.out.println(cal());
	}
	static int cal() {
		boolean[] chk = new boolean[101];
		
		Queue<int[] > q = new ArrayDeque<>();
		q.add(new int[] {1, 0});
		
		int res = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int[] x = q.poll();
			int nx = x[0];
			int cnt = x[1];

			if(nx == 100) {
				res = res > cnt ? cnt : res;
			}
			else if( nx > 100) continue;
			
			for(int i=1; i<=6; i++) {
				int dx = nx + i;
				
				if(dx > 100 || chk[dx]) continue;
				chk[dx] = true;
				
				if(bam.containsKey(dx)) {
					if(!chk[bam.get(dx)]) q.add(new int[] {bam.get(dx), cnt + 1});
				}
				else q.add(new int[] {dx, cnt + 1});
			}
		}
		return res;
	}
}
