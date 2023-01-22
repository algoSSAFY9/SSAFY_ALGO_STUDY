package 백준;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class kej2346 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// LinkedList 쓰면 메모리 초과 뜸,,,,,, 개빡침 ㅡㅡ 
		// ArrayDeque 쓰면 안뜸,,, 징짜 짜증나;
		Deque<int[]> q = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		
		for(int i = 0;i<n;i++) {
			q.add(new int[]{i+1,sc.nextInt()});
		}

		while(true) {
			if(q.size()==1) {
				int check[] = q.pollFirst();		// 큐에남은게 1개일때 while 멈추고 출력!! 
				sb.append(check[0]).append(" ");
				break;
			}
			int check[] = q.pollFirst();
			if(check[1] > 0) {						// 양수일때  
				for(int i = 1;i<check[1];i++) {
					q.addLast(q.pollFirst());
				}
				
			}	
			else {									// 음수일때  
				for(int i = 0;i<-(check[1]);i++) {
					q.addFirst(q.pollLast());
				}
					
			}
			
			sb.append(check[0]).append(" ");
			//System.out.print(check[0]+" ");
		}
		
		System.out.print(sb);
		
	}

}
