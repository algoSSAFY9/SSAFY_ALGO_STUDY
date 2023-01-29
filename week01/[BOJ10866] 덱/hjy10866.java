import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class hjy10866 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			
			switch (str[0]) {
			// push_front
			case "push_front" :{
				queue.offerFirst(Integer.parseInt(str[1]));
				break;
			}
			// push_back 
			case "push_back" :{
				queue.offerLast(Integer.parseInt(str[1]));
				break;	
			}
			// pop_front
			case "pop_front" :{
				if(queue.isEmpty())
					bw.write("-1\n");
				else
					bw.write(queue.pollFirst() + "\n");
				break;	
			}	
			// pop_back
			case "pop_back" :{
				if(queue.isEmpty())
					bw.write("-1\n");
				else
					bw.write(queue.pollLast().toString() + "\n");
				break;	
			}	
			// size
			case "size" :{
				bw.write(queue.size() + "\n");
				break;	
			}		
			// empty
			case "empty" :{
				if(queue.isEmpty())
					bw.write("1\n");
				else
					bw.write("0\n");
				break;	
			}		
			// front
			case "front":{
				if(queue.isEmpty())
					bw.write("-1\n");
				else
					bw.write(queue.peekFirst().toString() + "\n");
				break;	
			}	
			// back
			case "back":{
				if(queue.isEmpty())
					bw.write("-1\n");
				else
					bw.write(queue.peekLast().toString() + "\n");
				break;	
			}
			default:
				break;
			}
		}
		bw.flush();
		bw.close();		
		br.close();
	}

}
