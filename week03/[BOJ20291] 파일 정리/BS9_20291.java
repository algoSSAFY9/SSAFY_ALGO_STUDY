package algoStudy.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/*
 * [파일정리]
 * 힌트는 확장자
 * 확장자별로 파일의 개수
 * 확장자들을 사전 순으로 정렬
 * 
 * N 입력
 * N개의 파일명 입력
 * 
 * TreeMap
 */
public class BS9_20291 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> files = new TreeMap<>();
		
		String str;
		String sub;
		for(int i=0; i<N; i++) {
			str = br.readLine();
			sub = str.substring(str.indexOf(".")+1);
			files.put(sub, files.getOrDefault(sub, 0)+1);
		}
		
		files.forEach((k,v) -> sb.append(k).append(" ").append(v).append("\n"));
		
		System.out.println(sb);
	}
}
