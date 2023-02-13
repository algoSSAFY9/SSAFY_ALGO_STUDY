package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kej1244 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] sw = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i < N + 1; i++) {
			sw[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		int a, b; // a는 성별 b는 스위치 위치
		int L, R;
		int flag = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()); // 성별
			b = Integer.parseInt(st.nextToken()); // 스위치

			if (a == 1) { // 남자면
				for (int j = 1; j < N + 1; j++) {
					if (j % b == 0) {
						if (sw[j] == 0)
							sw[j] = 1;
						else
							sw[j] = 0;
					}
				}
			} else if (a == 2) { // 여자면
				L = b; // 왼쪽오른쪽 비교해야지,,,
				R = b; // 시작은 b에서 옆으로 가야지,,
				while (true) {
					if (L <= 1 || R >= N) break;
					else if(sw[L-1]!=sw[R+1]) break;
					else if (sw[L - 1] == sw[R + 1]) {
						L -= 1;
						R += 1;
						flag = 1;
					}
				}
				if (flag == 1) { // 좌우대칭이 존재할 때
					for (int x = L; x <= R; x++) {
						if (sw[x] == 0)
							sw[x] = 1;
						else
							sw[x] = 0;
					}
				}
				else {
					if (sw[b] == 0)
						sw[b] = 1;
					else
						sw[b] = 0;
				}
			}

		}
		for(int i = 1; i<sw.length;i++) {
			System.out.print(sw[i]+" ");
			if(i%20 == 0) {
				System.out.println();
			}
		}

	}

}
