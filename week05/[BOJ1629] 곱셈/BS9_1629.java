package algorithm_study.분할정복;

import java.io.*;
import java.util.*;

// (A^B)%C = ?

// 지수법칙 : a^(n+m) = a^n * a^m
// 모듈러 성질 : (a*b)%c = (a%c * b%c)%c
public class BS9_1629 {

	static int C, AC;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		AC = A%C;
		
		System.out.println(pow(A, B));
	}
	
public static long pow(int a, int b) {
		if(b == 1) {
			return AC;
		}
		
		long temp = pow(a, b / 2);
		
		if(b % 2 == 1) {
			return (temp * temp % C) * a%C;
		}
		return temp * temp % C;
		
	}
}
