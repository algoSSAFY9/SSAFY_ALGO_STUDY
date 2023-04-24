import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class hjw7432 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Trie root = new Trie();
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			root.add(line.split("\\\\"));
		}
		root.print("");
		System.out.println(sb.toString());
	}
	
	static class Trie {
		Node node;
		
		Trie() {
			node = new Node();
		}
		
		void add(String[] str) {
			Node trie = node;
			
			for(String s : str) {
				if(!trie.map.containsKey(s)) {
					trie.map.put(s, new Node());
				}
				trie = trie.map.get(s);
			}
		}
		
		void print(String str) {
			Node trie = node;
			
			for(String key : trie.map.keySet()) {
				sb.append(str).append(key).append("\n");
				node = trie.map.get(key);
				print(str+" ");
			}
		}
	}
	
	static class Node {
		TreeMap<String, Node> map;
		
		Node() {
			map = new TreeMap<>();
		}
	}
}
