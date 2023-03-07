import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class hjw11723 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		
		int[] arr = new int[21];
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			String[] line = br.readLine().split(" ");
			
			switch (line[0]) {
				case "all": Arrays.fill(arr, 1);
					break;
				case "empty": Arrays.fill(arr, 0);
					break;
				case "add": 
					arr[Integer.parseInt(line[1])] = 1;
					break;
				case "remove": arr[Integer.parseInt(line[1])] = 0;
					break;
				case "check": sb.append(arr[Integer.parseInt(line[1])]).append("\n");
					break;
				case "toggle": 
					int num = Integer.parseInt(line[1]);
					arr[num] = arr[num] == 1 ? 0 : 1;
					break;
			}
		}
		System.out.println(sb.toString());
	}

}
