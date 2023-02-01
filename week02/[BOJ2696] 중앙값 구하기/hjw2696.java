import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class hjw2696 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<T; i++) {
			int num = sc.nextInt();
			
			int[] arr = new int[num];
			Arrays.fill(arr, Integer.MAX_VALUE);
			ArrayList<Integer> ary = new ArrayList<>();
			
			for(int j=0; j<num; j++) {
				int n = sc.nextInt();
				arr[j] = n;
				if(j % 2 == 0) {
					Arrays.sort(arr);
					ary.add(arr[j/2]);
				}
			}
			sb.append(ary.size()).append("\n");
			int cnt = 0;
			for(int j=0; j<ary.size(); j++) {
				if(cnt == 10) {
					sb.append("\n");
					cnt = 0;
				}
				cnt++;
				sb.append(ary.get(j)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
