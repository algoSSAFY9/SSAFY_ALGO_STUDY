package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kej2630 {
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		check(0, 0, N);
		System.out.println(white);
		System.out.println(blue);

	}

	static int blue = 0;
	static int white = 0;

	static void check(int a, int b, int n) {
		int size = n;
		int num = arr[a][b];
		int flag = 0;

		for (int i = a; i < a + size; i++) {
			for (int j = b; j < b + size; j++) {
				if (num != arr[i][j]) {
					flag = 1; // �����ؾ߰ڴ�!
					break;
				}
			}
			if (flag == 1)
				break;
		}

		if (flag == 0) { // ���� ���� ����
			if (num == 1)
				blue++; // �Ķ���++
			if (num == 0)
				white++; // Ⱥ��++
		}

		if (flag == 1) {
			size = n / 2;

			check(a, b, size); // ���� ��
			check(a, b + size, size); // ������ ��
			check(a + size, b, size); // ���� �Ʒ�
			check(a + size, b + size, size); // ������ �Ʒ�
		}
	}

}
