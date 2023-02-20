import java.io.BufferedReader;
import java.io.InputStreamReader;

// char 형이 아닌 int형을 사용해서 영역이 같은 값인지를 확인할 때 합계를 사용-> 더 빠르나...?
public class BS9_1992 {

	static StringBuilder sb;
	static char[][] video;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb= new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		video = new char[N][];
		
		for(int i=0; i<N; i++) {
			video[i]=br.readLine().toCharArray();
		}
		
		dfs(0, 0, N);
		System.out.println(sb);
	}

	static void dfs(int y, int x, int n) {
		char c = video[y][x];
		
		for(int i=y; i<y+n; i++) {
			for(int j=x; j<x+n; j++) {
				if(video[i][j]!=c) {
					n=n/2;
					sb.append("(");
					dfs(y, x, n);
					dfs(y, x+n, n);
					dfs(y+n, x, n);
					dfs(y+n, x+n, n);
					sb.append(")");
					return;
				}
			}
		}
		sb.append(c);
	}
}
