import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hjy1992 {
	public static int[][] map;
	public static StringBuilder sb = new StringBuilder();
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';	// 공백없는 문자열 쪼개기
			}
		}
		
		QuadTree(0, 0, N);
		System.out.println(sb);
	}
	
	public static void QuadTree(int x, int y, int size) {
		
		boolean flag = true;	// 압축 가능 여부
		
		// 압축이 가능한지 공간을 확인
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				// 다른 수 하나 있을 경우
				if(map[x][y] != map[x + i][y + j]) {
					flag = false;
					break;
				}
				if(!flag) break;
			}
		}
		
		// 압축 가능하면 압축
		if(flag) {    
			sb.append(map[x][y]);
			return;
		}
		else {
			int n_size = size / 2;	// 압축 불가능 : 사이즈를 절반으로
			
			sb.append('(');	
			
			QuadTree(x, y, n_size);						// 1/4
			QuadTree(x, y + n_size, n_size);			// 2/4
			QuadTree(x + n_size, y, n_size);			// 3/4
			QuadTree(x + n_size, y + n_size, n_size);	// 4/4
			
			sb.append(')');
		}
				
	}	
}
