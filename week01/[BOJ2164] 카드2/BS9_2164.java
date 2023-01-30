package algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// N이 짝수라면 2개가 남았을때 while문을 돌리고 1개가 남음
// N이 홀수라면 1개가 남았을때 while문 탈출 - 1개 남음
// Queue - LinkedList 사용법을 익혔다!
// poll은 아무것도 없을때 null 반환 / remove는 오류 발생
public class BS9_2164  {
	static Queue<Integer> queue = new LinkedList<>();
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N =  Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		
		while(queue.size()>1) {
			queue.poll(); // 맨 윗 카드 제거
			
			queue.add(queue.poll()); // 맨 뒷장으로 보내기
		}
		System.out.println(queue.poll()); // poll 하면 제거와 동시에 리턴
	}
}