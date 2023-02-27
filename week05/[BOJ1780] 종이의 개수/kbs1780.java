import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kbs1780 {
	static int[][] paper;
	static int[] ans = new int[3];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		paper = new int[n][n];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		find(0,0,n);
		System.out.println(ans[0]);
		System.out.println(ans[1]);
		System.out.println(ans[2]);
		
	}
	
	
	static void find(int right, int down, int num) {
		int check = paper[right][down];
		for(int i=right; i<right+num;i++) {
			for (int j = down; j < down+num; j++) {
				if(paper[i][j]!=check) {
					for(int k=0;k<3;k++) {
						for(int l=0;l<3;l++) {
							find(right + k * (num / 3), down + l * (num / 3), num / 3);
						}
					}
					return;
				}
			}
		}
		
		if(check == -1) ans[0]+=1;
		else if(check == 0) ans[1]+=1;
		else ans[2]+=1;
	}
}
