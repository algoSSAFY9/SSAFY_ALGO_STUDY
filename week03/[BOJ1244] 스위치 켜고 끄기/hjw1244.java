import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class hjw1244 {
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int num = Integer.parseInt(br.readLine());
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			
			if(sex == 1) { // 남학생
				for(int j=idx; j<=n; j+=idx) {
					arr[j] = 1 - arr[j];
				}
			}
			else {
				arr[idx] = 1 - arr[idx];
				girl(idx-1, idx+1);
			}
		}
		
		for(int i=1; i<=n; i++) {
			bw.write(arr[i] + " ");
			if(i % 20 == 0) bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}

	static void girl(int start, int end) {
		if(start > 0 && end < arr.length && arr[start] == arr[end]) {
			arr[start] = 1 - arr[start];
			arr[end] = 1 - arr[end];
			girl(start-1, end+1);
		}
	}
	
}
