import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hjy7568 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 몸무게, 키 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); //몸무게
			arr[i][1] = Integer.parseInt(st.nextToken()); //키
		}
		 
		for (int i = 0; i < N; i++) {
			int rank = 1;	// 등수
			for (int j = 0; j < N; j++) {
				if(i == j) 
					continue;
				// 이전 값이 무게 키 다 작으면 등수 +1 : 자기보다 큰 사람 나올 때마다 +1
				else if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) 
					rank++;
			}
			sb.append(rank).append(' ');
		}
		System.out.println(sb);
		}
}
	
