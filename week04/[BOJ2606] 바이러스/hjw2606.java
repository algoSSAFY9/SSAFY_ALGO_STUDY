import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class hjw2606 {
	static int com = 0;
	static boolean[] chk;
	static ArrayList<Integer>[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[N+1];
		
		for(int i=0; i<N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		chk = new boolean[N+1];
		
		for(int i=0; i<cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			arr[one].add(two);
			arr[two].add(one);
		}
		
		cal(1);
		System.out.println(com);
		
	}
	
	static void cal(int start) {
		chk[start] = true;
		for(int i=0; i<arr[start].size(); i++) {
			int x = arr[start].get(i);
			if(!chk[x]) {
				com++;
				cal(x);
			}
		}
	}
	
}
