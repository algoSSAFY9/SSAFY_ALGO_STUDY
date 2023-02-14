package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kej2798 {
	static int[] src;
	static boolean[] select;
	static int[] target = new int[3];
	static int max = 0;
	static int M;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		src = new int[N];
		select = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int t = 0; t < N; t++) {
			src[t] = Integer.parseInt(st.nextToken());
		}

		perm(0);
		System.out.println(max);
	}

	static void perm(int tgtIdx) {
		int sum = 0;
		if (tgtIdx == target.length) {
			for (int i : target) {
				sum += i;
			}
			if (Math.abs(sum - M) < Math.abs(max - M))
				if(sum <= M) max = sum;
			return;
		}

		for (int i = 0; i < src.length; i++) {
			if(select[i]) continue;
			target[tgtIdx] = src[i];
			select[i] = true;
			perm(tgtIdx+1);
			select[i] = false;
			
		}
	}

}