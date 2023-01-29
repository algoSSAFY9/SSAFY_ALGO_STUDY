import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class hjy18258 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());	// 명령의 수
		
		// Queue 객체 생성.
		Deque<Integer> queue = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();		// 한줄씩 읽어옴
			
			// push
			if(str.contains("push")) { 
				String spt[] = str.split(" ");	// 공백을 기준으로 분할
				queue.offer(Integer.parseInt(spt[1]));	// 정수값 push
			}
			// pop
			else if(str.contains("pop")) { 
				if(queue.isEmpty()) 		
					bw.write(-1+"\n"); 	// 빈 경우 -1 출력	
				else 
					bw.write(queue.poll()+"\n");			
			}
			// size
			else if(str.contains("size")) { 
				bw.write(queue.size()+"\n");
			}
			// empty
			else if(str.contains("empty")) { 
				if(queue.isEmpty()) 
					bw.write(1+"\n"); 	// 빈 경우 1 출력
				else 
					bw.write(0+"\n");	// 비어있지 않을 경우 0 출력
			}
			// front
			else if(str.contains("front")) { 
				if(queue.isEmpty())
					bw.write(-1+"\n");	// 빈 경우 -1 출력									
				else 
					bw.write(queue.peek()+"\n");
			}
			// back
			else if(str.contains("back")) { 
				if(queue.isEmpty())
					bw.write(-1+"\n");	// 빈 경우 -1 출력									
				else 
					bw.write(queue.peekLast()+"\n");
			}
		}
		
		bw.flush();
		bw.close();		
		br.close();
		
	}
}