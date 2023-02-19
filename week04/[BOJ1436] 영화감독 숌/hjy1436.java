import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hjy1436 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
 
		int num = 666;
		int cnt = 1;
        
		while(cnt != N) {
			num++;
			// 666 부터 증가하는 수 num 값을 문자열로 변환해 검사
			if(String.valueOf(num).contains("666")) {
				cnt++;
			}
		}
		System.out.println(num);
	}
}
