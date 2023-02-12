package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class hjy20291 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb;
		
		int N = Integer.parseInt(br.readLine());	// 파일의 개수
		Map<String, Integer> map = new TreeMap<>();
				
		for (int i = 0; i < N; i++) {
			String[] name = br.readLine().split("[.]");		// .을 기준으로 나누기
			String extension = name[1];		// 확장자 이름
			if(map.containsKey(extension)) {
				map.replace(extension, map.get(extension)+1);
			}
			else
				map.put(extension, 1);
		}
		
		// 출력
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
			
	}
} 
