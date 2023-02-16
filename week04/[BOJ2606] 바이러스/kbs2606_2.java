import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/* (python의 dictionary 처럼 쓰려고 하다가 사용한 방법 
 * -> HashMap <Integer, List<Integer>>)
 	test case 예
	{1=[2, 5], 2=[1, 3, 5], 3=[2], 4=[7], 5=[1, 2, 6], 6=[5], 7=[4]}
 */
public class kbs2606_2 {

	static Map<Integer, List<Integer>> comLinks = new HashMap<>();
	static boolean[] virus;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int coms = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		virus = new boolean[coms + 1];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (!comLinks.containsKey(a))
				comLinks.put(a, new ArrayList<>());
			if (!comLinks.containsKey(b))
				comLinks.put(b, new ArrayList<>());
			comLinks.get(a).add(b);
			comLinks.get(b).add(a);
		}
		check(1);

		// result
		int cnt = 0;
		for (int i = 2; i < virus.length; i++) {
			if (virus[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	public static void check(int cur) {
		if (virus[cur])
			return;
		virus[cur] = true;
//		if (!comLinks.containsKey(cur))
//			return;
		for (int i = 0; i < comLinks.get(cur).size(); i++) {
			check(comLinks.get(cur).get(i));
		}
	}
}
