import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

class problem implements Comparable<problem>{
	int ord; // 난이도
	int pname; // 문제번호
	
	public problem(int ord, int pname) {
		this.ord = ord;
		this.pname = pname;
	}

	@Override
	public int compareTo(problem o) {
		if(o.ord == this.ord) return this.pname - o.pname;
		return this.ord - o.ord;
	}
}
public class hjw21939 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		TreeSet<problem> t = new TreeSet<>();
		
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int pn = Integer.parseInt(st.nextToken());
			int ord = Integer.parseInt(st.nextToken());
			
			t.add(new problem(ord, pn));
			tm.put(pn, ord);
		}
		
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			String[] str = br.readLine().split(" ");
			int pname = Integer.parseInt(str[1]);
			
			if(str[0].equals("add")) {
				t.add(new problem(Integer.parseInt(str[2]), pname));
				tm.put(pname, Integer.parseInt(str[2]));
			}
			else if(str[0].equals("recommend")) {
				int x = pname == 1 ? t.last().pname : t.first().pname;
				sb.append(x).append("\n");
			}
			else {
				t.remove(new problem(tm.get(pname), pname));
				tm.remove(pname);
			}
		}
		System.out.println(sb.toString());
	}

}
