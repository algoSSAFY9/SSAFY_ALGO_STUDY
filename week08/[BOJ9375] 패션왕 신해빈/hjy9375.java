import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class hjy9375 {
	public static void main(String[] args) throws IOException {
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
 
		int T = Integer.parseInt(br.readLine());	
 
		for(int tc = 0; tc < T; tc++) {
			
			HashMap<String, Integer> hmap = new HashMap<>();	// 옷 종류, 해당 종류의 숫자
			
			int N = Integer.parseInt(br.readLine());	// 입력받는 옷의 개수
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				String name = st.nextToken();	// 옷 이름	
				String kind = st.nextToken();	// 옷 종류 
				
				if (hmap.containsKey(kind)) {	// 옷 종류 이미 존재 : 숫자 증가
					hmap.put(kind, hmap.get(kind) + 1);
				} 
				else {		// 옷 종류 없던거 : 추가
					hmap.put(kind, 1);
				}
			}
 
			int rst = 1;
 
			// 해당 종류를 안 입는 경우 생각 : rst * (종류별 옷의 개수 +1)
			for (int cnt : hmap.values()) {
				rst *= (cnt + 1);
			}
			
			// 알몽인 경우의 수 1 빼기
			sb.append(rst - 1).append("\n");
 
		}
		System.out.println(sb);
	}
}
