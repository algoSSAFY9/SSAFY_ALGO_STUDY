import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class hjy18870 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int X[]=new int[N];		// 좌표값
		int n_X[]=new int[N];	// 정렬된 좌표값
		
		HashMap<Integer,Integer> hmap = new HashMap<>();	// key:좌표  vlaue:압축 좌표
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		
		for(int i=0; i<N; i++) {
			X[i] = Integer.parseInt(st.nextToken());
		}
		
		n_X = X.clone();	// X를 복사
		Arrays.sort(n_X);
		
		int n_x = 0;	// 압축 좌표
		for(int i = 0; i < N; i++) {
			if(!hmap.containsKey(n_X[i])) {
				hmap.put(n_X[i], n_x++);
			}
		}
		
		for(int i = 0; i < N; i++)
			sb.append(hmap.get(X[i])).append(" ");
		
		System.out.print(sb);
	    
	}
}
