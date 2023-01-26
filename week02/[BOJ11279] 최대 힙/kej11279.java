package 백준문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;


public class kej11279 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> arr = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0;i<n;i++) {
			int a = Integer.parseInt(br.readLine());
			if(a == 0) {
				if(arr.isEmpty()) {
					System.out.println("0");
				}
				else {
					System.out.println(arr.poll());
				}
			}
			else {
				arr.add(a);
			}
		}

	}

}
