import java.io.BufferedReader;
import java.io.InputStreamReader;

public class hjy5525 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());	// 몇번째 P인지
		int M = Integer.parseInt(br.readLine());	// S 길이
		char s[] = br.readLine().toCharArray();

		int rst = 0;
		int cnt = 0;

		// -1, +1 을 위해 범위 1 ~ M-1
		for(int i = 1; i < M - 1; i++) {
			if(s[i - 1] == 'I' && s[i] == 'O' && s[i + 1] == 'I') {
				cnt++;
					// 원하던 개수까지 도달 
					if(cnt == N) {
						cnt--;
						rst++;
					}
	                i++;
			}
			else {
				cnt = 0;
			}
		}

		System.out.println(rst);

	} 
}
