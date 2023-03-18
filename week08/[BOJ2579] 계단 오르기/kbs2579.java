import java.io.BufferedReader;
import java.io.InputStreamReader;

public class kbs2579 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[N+1];
		int[] check = new int[N+1];
		for(int i=1;i<=N;i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		check[1] = stairs[1]; 
		if(N>=2) check[2] = stairs[1]+stairs[2]; 

		for(int i=3;i<=N;i++) {
			check[i] = Math.max(check[i-2], check[i-3]+stairs[i-1]);
			check[i]+=stairs[i];
		}
		
		System.out.println(check[N]);
	}
}
/* 계속 헷갈렸던거 => "세번 연속" 
	1,2,3 X
	1계단 2계단 -> 3X  -> 4
	최대 2칸임
	
	i=5라면,
	1. i=3 + 2칸
	2. i=2+ i=4+ 1칸 
	3. i=3 + i=4 하면 i=5 절대 안됨 -> 따라서 한칸짜리를 하려면 두칸짜리를 거치고와야 한칸 ㅇㅇ 

	따라서, i번째 계단을 밟을때 최댓값은
	1. 2칸 전꺼 (2계단 숙 올라왔을 때)
	2. 1칸 전꺼 ( 한칸전 해당 값 + 세칸전합 ) 
		
*/