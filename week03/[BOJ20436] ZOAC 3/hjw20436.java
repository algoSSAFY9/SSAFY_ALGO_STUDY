import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hjw20436 {
	static char[][] arr = {{'q','w','e','r','t'}, 
			{'a','s','d','f','g'}, 
			{'z','x','c','v'}};
	static char[][] brr = {{'.','y','u','i','o','p'}, 
			{'.','h','j','k','l'}, {'b','n','m'}};
	
	static int lx, ly, rx, ry;
	static boolean chk;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		char l = st.nextToken().charAt(0);
		leftchk(l);
		char r = st.nextToken().charAt(0);
		rightchk(r);
		String line = br.readLine();
		
		int min = 0, result = 0;
		for(int i=0; i<line.length(); i++) {
			int lx1 = lx, ly1 = ly, rx1 = rx, ry1 = ry;
			chk = false;
			leftchk(line.charAt(i));
			if(chk) {
				result = Math.abs(lx-lx1) + Math.abs(ly-ly1);	
			}
			else {
				rightchk(line.charAt(i));
				result = Math.abs(rx-rx1) + Math.abs(ry-ry1);
			}
			
			min += result;
		}
		System.out.println(min + line.length());
		
	}
	static void leftchk(char x) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j] == x) {
					lx = i; ly = j;
					chk = true;
					return;
				}
			}
		}
	}
	static void rightchk(char x) {
		for(int i=0; i<brr.length; i++) {
			for(int j=0; j<brr[i].length; j++) {
				if(brr[i][j] == x) {
					rx = i; ry = j;
					chk = false;
					return;
				}
			}
		}
	}

}