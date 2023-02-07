import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hjw20546 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = n;
		int[] arr = new int[14];

		StringTokenizer st = new StringTokenizer(br.readLine());

		int junCnt = 0, sungCnt = 0;
		int sungIn = 0, sungDe = 0;
		for (int i = 0; i < 14; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			int x = n / arr[i];
			
			if (x > 0) { // ����
				junCnt += x;
				n -= (arr[i] * x);
			}
		}
		
		// ����
		for (int i = 1; i < 14; i++) {
			int y = m / arr[i];

			if (arr[i - 1] < arr[i]) { // ��� - �ŵ� ���ɼ�
				if (sungDe > 0)
					sungDe = 0;
				sungIn++;
			}
			else if (arr[i - 1] > arr[i]) { // �϶� - �ż� ���ɼ�
				if (sungIn > 0)
					sungIn = 0;
				sungDe++;
			}
			else if(arr[i-1] == arr[i] ) { // ���� ���� pass
				sungDe = 0;
				sungIn = 0;
			}

			if (sungIn >= 3) { // �ŵ� - �Ǵ�.
				m += sungCnt * arr[i];
				sungCnt = 0;
			} 
			else if (sungDe >= 3) { // �ż� - ���.
				m -= (arr[i] * y);
				sungCnt += y;
			}
		}
		
		int junMoney = arr[13] * junCnt + n;
		int sungMoney = arr[13] * sungCnt + m;
		if(junMoney < sungMoney) {
			System.out.println("TIMING");
		}
		else if(junMoney > sungMoney) {
			System.out.println("BNP");
		}
		else System.out.println("SAMESAME");
	}

}
