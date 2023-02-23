import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kbs14888 {
	static int[] A;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] op = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			op[i]= Integer.parseInt(st.nextToken());
		}
		
		cal(op[0],op[1],op[2],op[3],A[0],1);
		System.out.println(max);
		System.out.println(min);
	}
	
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static void cal(int p, int mi, int mul, int d, int res, int idx) {
		if(idx==A.length) {
			max = Math.max(max, res);
			min = Math.min(min, res);
			return;
		}
		if(p>0) cal(p-1,mi,mul,d,res+A[idx], idx+1);
		if(mi>0) cal(p,mi-1,mul,d,res-A[idx], idx+1);
		if(mul>0) cal(p,mi,mul-1,d,res*A[idx], idx+1);
		if(d>0) cal(p,mi,mul,d-1,(int)(res/A[idx]), idx+1);
		
		return;
	}
}
	
