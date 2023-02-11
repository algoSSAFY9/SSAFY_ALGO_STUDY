package algorithm_study.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * N개의 기차
 * 기차 - 20개의 일렬로된 좌석
 * 기차 번호 : 1 ~ N
 * M개의 명령
 * 
 * 1ix: i번째 기차 x번째 좌석에 사람태움 -> 이미 있으면 무시
 * 2ix: i번째 기차 x번째 좌석 사람 하차 -> 아무도 없으면 무시
 * 3ix: i번째 기차 승객 모두 뒤로 한칸씩 이동, k->k+1, 20번째 사람은 하차
 * 4ix: i번째 기차 승객 모두 앞으로 한칸 이동, k->k-1, 1번째 사람은 하차
 * 
   *   ※기차는 연속된것이 아님. 마지막엔 기차 전체 탐색해서 중복체크해야함.
 * HashSet을 사용할 때 크기를 미리 지정해주면 속도가 좀 더 빨라짐.
 * 	대신 메모리 사용량이 좀 더 커짐.
 */
public class BS9_15787 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] train = new int[N+1]; // 0은 사용 x
		int limit = 1048575; //2^20-1
		
		Set<Integer> set = new HashSet<>(limit+1); // 중복제거
		
		int command, num, idx;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			command = st.nextToken().charAt(0);
			num = Integer.parseInt(st.nextToken());
			
			switch(command) {
			case '1':{ // 승차
				idx = Integer.parseInt(st.nextToken())-1; //0~19
				train[num]=train[num]|1<<idx;
				break;
			}
			case '2':{ // 하차
				idx = Integer.parseInt(st.nextToken())-1; //0~19
				train[num]=train[num]&~(1<<idx);
				break;
			}
			case '3':{ // 뒤로 이동 <<
				train[num]=(train[num]<<1)&limit;
				break;
			}
			case '4':{ // 앞으로 이동 >>
				train[num]=train[num]>>1;
				break;
			}
			}
		}
		for(int i=1; i<=N; i++) {
			set.add(train[i]);
		}
		System.out.println(set.size());
	}
}
