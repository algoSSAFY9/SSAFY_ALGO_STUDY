import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class hjw11403 {
	static ArrayList<Integer>[] map;
	static final int INF = 987654321;
	static int start;
	static boolean[] chk;
	static int[][] res;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		map = new ArrayList[N];
		for(int i=0; i<N; i++) {
			map[i] = new ArrayList<>();
		}
		
		res = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					map[i].add(j);
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			chk = new boolean[N];
			start = i;
			cal(i);
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(res[i][j]).append(" ");
			}
			sb.append("\n");
		}
			
		
		System.out.println(sb.toString());
	}
	
	static void cal(int x) {
		for(int i=0; i<map[x].size(); i++) {
			int get = map[x].get(i);
			if(chk[get]) continue;
			chk[get] = true;
			res[start][get] = 1;
			cal(get);
		}
	}
}
