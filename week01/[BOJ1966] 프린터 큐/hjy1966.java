import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class hjy1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 수
		
		for(int i = 0; i < T; i++) {
			Queue<Integer> queue = new LinkedList<>();	// 문서별 중요도 큐
			Queue<Integer> index = new LinkedList<>();	// 해당 문서의 index
			String[] nm = br.readLine().split(" ");
			int N = Integer.parseInt(nm[0]);	// 문서의 수 
			int M = Integer.parseInt(nm[1]);	// 찾고자 하는 문서의 index
			
			String[] str = br.readLine().split(" ");
			// 중요도, index 큐에 저장
			for(int j = 0; j < N; j++) {
				queue.offer(Integer.parseInt(str[j]));
				index.offer(j);
			}
			int cnt = 0;
			while (!queue.isEmpty()) {
	    		int cur = queue.poll(); // 현재 문서의 중요도
	    		int curIndex = index.poll(); // 현재 인덱스
	    		boolean isMax = true;	// cur가 가장 큰 중요도를 가지는지 판단하는 변수
	    		
	    		for (int q : queue) {
	    			// 현재 문서가 큐 내부에서 가장 큰 중요도를 가지지 않을 경우
					if(q > cur) {
						isMax = false;
						break;
					}
				}
				
	    		// 현재 문서가 큐 내부에서 가장 큰 중요도를 가질 경우
				if(isMax) {
					cnt++;
					// 현재 문서가 찾고자 하는 문서일 경우
					if(curIndex == M) 
						break;
				}
				// 큐의 맨뒤로 문서 보냄
				else {
					queue.offer(cur);
					index.offer(curIndex);
				}
	    	}
			System.out.println(cnt);
			
		}
		
	}

}
