package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class kej18870 {
	static int N;
	static int[] list;
	static int[] list_sort;
	static HashMap<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		list = new int[N];
		list_sort = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		list_sort = list.clone();
		Arrays.sort(list_sort);

		int num = 0;
		for (int i = 0; i < N; i++) {
			if (!map.containsKey(list_sort[i])) {
				map.put(list_sort[i], num++);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(map.get(list[i])).append(" ");
		}
		System.out.println(sb);
	}

}
