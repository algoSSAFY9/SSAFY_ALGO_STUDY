package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// IOIOI
public class kej5525 {
	static int N, M;
	static int cnt = 0;
	static int res = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		String s = br.readLine();

		char[] c = new char[s.length()];

		for (int i = 0; i < s.length(); i++) {
			c[i] = s.charAt(i);
		}

		int flag = 0;
		// IOI찾기..
		// IOI찾으면 두칸 점프 해서 다시 I부터 보기
		for (int i = 2; i < c.length; i++) {
			if (flag == 1) {
				// cnt랑 N이랑 같은 찾은수 +1 해주기
				if (cnt == N) {
					res++;
					cnt -= 1;
				}
			}
			if (c[i - 2] == 'I' && c[i - 1] == 'O' && c[i] == 'I') {
				// ioi가 이어져 있음을 flag로 표현
				flag = 1;
				// cnt로 Pn에 n이 몇인지 확인
				cnt++;
				i += 1;
			} else {
				// ioi가 끝어졌으면
				flag = 0;
				cnt = 0;
			}
			// ioi가 이어져있다 끊어지면 cnt++ 하고 다시 0으로
		}
		if (flag == 1) {
			// cnt랑 N이랑 같은 찾은수 +1 해주기
			if (cnt == N) {
				res++;
				cnt -= 1;
			}
		}
		System.out.println(res);

	}

}
