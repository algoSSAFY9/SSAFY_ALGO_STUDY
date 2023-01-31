import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

class bracket{
	int start;
	int end;
	
	public bracket(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
}
public class hjw2800 {
	static String line;
	static ArrayList<bracket> arr = new ArrayList<>();
	static TreeSet<String> ts = new TreeSet<>();
	static boolean[] chk;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine();
		
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == '(') {
				st.add(i);
			}
			else if (line.charAt(i) == ')') {
				arr.add(new bracket(st.pop(), i));
			}
		}
		chk = new boolean[line.length()];
		
		cal(0);
		
		StringBuilder sb = new StringBuilder();
		ts.pollFirst();
		for(String str : ts) {
			sb.append(str).append("\n");
		}
		System.out.println(sb.toString());
	}
		
	static void cal(int depth) {
		StringBuilder sb = new StringBuilder(); 
		if(depth == arr.size()) {
			for(int i=0; i<line.length(); i++) {
				if(!chk[i]) {
					sb.append(line.charAt(i));
				}
			}
			ts.add(sb.toString());
			return;
		}
		
		bracket br = arr.get(depth);
		chk[br.start] = false;
		chk[br.end] = false;
		cal(depth+1);
		
		chk[br.start] = true;
		chk[br.end] = true;
		cal(depth+1);
		
	}
}
