package Test;

public class test {

	static int N, hN, min=Integer.MAX_VALUE;
	static int[] r, l;
	public static void main(String[] args) throws Exception {
		N = read();
		hN=N/2;
		
		int total=0;
		r=new int[N];
		l=new int[N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int t=read();
				total+=t;
				r[i]+=t;
				l[j]+=t;
			}
		}
		
		dfs(1, 1, total-r[0]-l[0]);
		System.out.println(min);
	}

	static void dfs(int idx, int cnt, int temp) {
		if(min==0) return;
		if(cnt==hN) {
			min=Math.min(min, Math.abs(temp));
			return;
		}
		if(hN-cnt>N-idx) return;
		
		for(int i=idx; i<N; i++)
			dfs(i+1, cnt+1, temp-r[i]-l[i]);
	}
	private static int read() throws Exception {
	    int d,o =  System.in.read()&15;
	    while((d= System.in.read())>32) o = (o<<3)+(o<<1)+(d&15);
	    return o;
	}
}