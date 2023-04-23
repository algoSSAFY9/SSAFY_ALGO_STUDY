import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class boj14725 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Node root = new Node();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			
			root.insert(K);
		}
		root.print("");
		System.out.println(sb.toString());
	}
	
	static class Node {
		TrieNode node;
		
		Node() {
			node = new TrieNode();
		}
		
		void insert(int k) {
			TrieNode nd = node;
			
			for(int i=0; i<k; i++) {
				String str = st.nextToken();
				if(!nd.map.containsKey(str)) {
					nd.map.put(str, new TrieNode());
				}
				nd = nd.map.get(str);
			}
		}
		
		void print(String str) {
			TrieNode nd = node;
			for(String s : nd.map.keySet()){
				sb.append(str).append(s).append("\n");
				node = nd.map.get(s);
				print(str + "--");
			}
		}
	}
	
	static class TrieNode {
		TreeMap<String, TrieNode> map = new TreeMap<>();

	}
}
