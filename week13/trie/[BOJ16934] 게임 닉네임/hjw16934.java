import java.io.BufferedReader;
import java.io.InputStreamReader;

public class hjw16934 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Trie t = new Trie();
		
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			t.add(line);
		}
		
		System.out.println(sb.toString());
	}
	
	static class Trie {
		Node tNode;
		
		Trie() {
			tNode = new Node();
		}
		
		void add(String str) {
			Node node = tNode;
			
			boolean chk = false;

			for(Character c : str.toCharArray()) {
				if(!chk) sb.append(c);
				
				int idx = c - 'a';
				if(node.ch[idx] == null) {
					node.ch[idx] = new Node();
					chk = true;
				}
				
				node = node.ch[idx];
			}
			
			node.cnt++;
			if(!chk && node.cnt >= 2) {
				sb.append(node.cnt);
			}
			sb.append("\n");
		}
	}
	
	static class Node {
		Node[] ch;
		int cnt;
		
		Node() {
			ch = new Node[26];
			cnt = 0;
		}
	}
}
