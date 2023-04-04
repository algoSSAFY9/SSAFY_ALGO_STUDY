import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class hjw1389 {
	static ArrayList<Integer>[] arr;
	static int size;
	static boolean[] chk;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 유저 수
		int M = Integer.parseInt(st.nextToken()); // 관계
		
		arr = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken()); 
			int two = Integer.parseInt(st.nextToken()); 
			
			arr[one].add(two);
			arr[two].add(one);
		}
		
		int min = 987654321, res = 0;
		for(int i=1; i<=N; i++) {
			chk = new boolean[N+1];
			chk[i] = true;
			size = 0;
			cal(i);
			
			if(min > size) res = i;
			min = size < min ? size : min;
		}
		
		System.out.println(res);
	}
	
	static void cal(int start) {
		Queue<int[] > q = new ArrayDeque<>();
		q.add(new int[] {start, 0});
		
		while(!q.isEmpty()) {
			int[] pol = q.poll();
			int x = pol[0];
			
			for(int i=0; i<arr[x].size(); i++) {
				int get = arr[x].get(i);
				
				if(chk[get]) continue;
				chk[get] = true;
				size += pol[1] + 1;
				
				q.add(new int[] {get, pol[1] + 1});
			}
		}
	}
}
