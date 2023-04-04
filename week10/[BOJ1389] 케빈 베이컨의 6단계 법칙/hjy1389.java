import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class hjy1389 {
	static int map[][]; 
	static boolean isVisited[];

	static int N;		// 유저의 수
	static int rst;		// 케빈 베이컨의 수가 가장 작은 사람
	static int min_cnt = Integer.MAX_VALUE;		// 가장 작은 케빈 베이컨의 수
	
	static class Person {
		int num;			// 사람 번호
		int kevin_cnt;	// 케빈 베이컨의 수

		public Person(int num, int kevin_cnt) {
			this.num = num;
			this.kevin_cnt = kevin_cnt;
		}
	} 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수

		map = new int[N + 1][N + 1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 방향 없는 그래프
			map[a][b] = 1;
			map[b][a] = 1;
		}

		for(int i=1; i<=N; i++) {
			isVisited = new boolean[N + 1];
			bfs(i);
		}

		System.out.println(rst);
	} 

	static void bfs(int start) {
		Queue<Person> que = new LinkedList<>();
		int cnt = 0;
		
		isVisited[start] = true;
		que.offer(new Person(start, 0));

		while(!que.isEmpty()) {
			Person person = que.poll();
			cnt += person.kevin_cnt;

			for(int i = 1; i <= N; i++) {
				int num = map[person.num][i];

				if(num >= 1 && isVisited[i] == false) {
					isVisited[i] = true;
					que.offer(new Person(i, person.kevin_cnt + 1));
				}
			}
		}

		if(min_cnt > cnt) {
			min_cnt = cnt;
			rst = start;
		}

	} 
}
