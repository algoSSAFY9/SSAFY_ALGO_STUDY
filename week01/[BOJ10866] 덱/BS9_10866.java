package algorithm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BS9_10866 {

	static int N;
	static int[] deque_f, deque_b;
	static int front, front_s, back, back_s, size;
	static StringTokenizer st;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		deque_f = new int[N];
		deque_b = new int[N];
		
		front=0; front_s=0; back=0; back_s=0; size=0;
		
		
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case("push_front"):{
				push_front(Integer.parseInt(st.nextToken()));
				break;
			}
			case("push_back"):{
				push_back(Integer.parseInt(st.nextToken()));
				break;
			}
			case("pop_front"):{
				sb.append(pop_front()+"\n");
				break;
			}
			case("pop_back"):{
				sb.append(pop_back()+"\n");
				break;
			}
			case("size"):{
				sb.append(size()+"\n");
				break;
			}
			case("empty"):{
				sb.append(empty()+"\n");
				break;
			}
			case("front"):{
				sb.append(front()+"\n");
				break;
			}
			case("back"):{
				sb.append(back()+"\n");
				break;
			}
			}
		}
		System.out.println(sb);
	}
	
	public static void push_front(int x) {
		deque_f[front++]=x;
		size++;
	}
	
	public static void push_back(int x) {
		deque_b[back++]=x;
		size++;
	}
	
	public static int pop_front() {
		if(front-front_s>0) {
			size--;
			return deque_f[--front];
		}
		else if(back-back_s>0) {
			size--;
			return deque_b[back_s++];
		}
		return -1;
	}
	
	public static int pop_back(){
		if(back-back_s>0) {
			size--;
			return deque_b[--back];
		}
		else if(front-front_s>0) {
			size--;
			return deque_f[front_s++];
		}
		return -1;
	}
	
	public static int size(){
		return size;
	}
	
	public static int empty(){
		if(size>0) return 0;
		return 1;
	}
	
	public static int front(){
		if(front-front_s>0) {
			return deque_f[front-1];
		}
		else if(back-back_s>0) {
			return deque_b[back_s];
		}
		return -1;
	}
	
	public static int back(){
		if(back-back_s>0) {
			return deque_b[back-1];
		}
		else if(front-front_s>0) {
			return deque_f[front_s];
		}
		return -1;
	}
}

