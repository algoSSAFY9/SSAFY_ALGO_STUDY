package algorithm_study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BS9_18258_ans { 
	
	static Queue<String> q = new LinkedList<>();
	static StringBuilder str = new StringBuilder();
	static int last = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < count; i++) {
			String data  = br.readLine();
			
			if(data.length() >= 6) { //push
				data = data.substring(5);
				push(data);
			} else if(data.equals("pop")){
				pop();
				
			} else if(data.equals("size")) {
				size();
				
			} else if(data.equals("empty")) {
				empty();
				
			} else if (data.equals("front")) {
				front();
				
			} else if (data.equals("back")) {
				back();
				
			}
		}
		bw.write(str.toString());
		bw.close();
		
	}
	
	public static void push(String data) { //정수 x를 큐에 넣기
		q.add(data);
		last = Integer.parseInt(data);
	}
	
	public static void pop() {
		if(q.size() != 0) {
			int result =(Integer.parseInt(q.remove()));
			str.append(result).append("\n");
			
		} else {
			str.append(-1).append("\n");
		}
	}
	
	public static void size() {
		str.append(q.size()).append("\n");
	}
	
	public static void empty() {
		if(q.size() == 0) { //비어있을 때 1
			str.append(1).append("\n");
		} else { //아니면 0
			str.append(0).append("\n");
		}
	}
	
	public static void front() {
		if(q.size() != 0) {
			str.append(q.peek()).append("\n");
		} else {
			str.append(-1).append("\n");
		}
		
	}
	
	public static void back() {
		if(q.size() != 0) {
			str.append(last).append("\n");
		} else {
			str.append(-1).append("\n");
		}
		
	}
}