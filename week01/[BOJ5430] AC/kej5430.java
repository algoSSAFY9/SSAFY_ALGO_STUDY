package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class kej5430 {

	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    Deque<Integer> dq = new ArrayDeque<>();
	    int n = Integer.parseInt(br.readLine());
	    int m;
	    for(int i = 0 ; i < n; i++) {
	    	String a = br.readLine();
	        String[] strArray = a.split("");
	        m = Integer.parseInt(br.readLine());        // 숫자갯수            
	        StringTokenizer st2 = new StringTokenizer(br.readLine(),"[,]"); // 숫자배열 읽어서 [,]로 끊어 읽기

	        for(int j = 0; j < m; j++) {			// 숫자 deque에 넣기
	            String num = st2.nextToken();
	            dq.add(Integer.parseInt(num));
	        }
	             
	        boolean front = true; //처음은 앞에서 부터 시작하니까 true 
	        boolean size = false;
	        for(int j = 0; j < a.length(); j++) {
	        	if(strArray[j].equals("R")) {	// R을 만나면 뒤쪽부터라는 뜻으로 false
	        		if(front) front = false;	// 다시 만나면 앞쪽부터 true
	        		else front = true;
	        	}
	        	
	        	if(strArray[j].equals("D")) {
	        		if(dq.size() == 0) {
	        			System.out.println("error"); 
	        			size = true;
	        			break;
	        		}
	        		if(front) {			// 정방향
	        			dq.pollFirst();
	        		} else dq.pollLast();	// 역방향
	        	}
	        }
	        
	        if(size) continue;
	        
	        StringBuilder sb=new StringBuilder();
	        sb.append("[");
	        while(dq.size()>1) {
	        	if(front) sb.append(dq.pollFirst()).append(",");
	        	else sb.append(dq.pollLast()).append(",");
	        }
	        if(dq.size()==0) sb.append("]");
	        else sb.append(dq.pollFirst()).append("]"); 

		    System.out.println(sb);
	        
	    }
	}

}
