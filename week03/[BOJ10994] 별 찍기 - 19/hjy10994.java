package week03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class hjy10994 {

	  public static void main(String[] args) throws IOException{
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		  StringBuilder sb;
		  
		  int N = Integer.parseInt(br.readLine());
		  int col_size = 4*(N-1) + 1;	// 가로의 길이
	
		  // 처음 ~ 중앙
		  for(int i = 1; i <= N; i++) {
			    
			  sb = new StringBuilder();
			  // 가운데 별 포함한 줄
			  for(int j = 0; j < (i-1); j++) {	// 왼쪽 외곽
				  sb.append("* ");
			  }
			  for(int j = 0; j < (col_size - 4*(i-1)); j++) {	// 가운데 별, 4개씩 감소
				  sb.append("*");
			  }
			  for(int j = 0; j < (i-1); j++) {	// 오른쪽 외곽
				  sb.append(" *");
			  }
			  sb.append("\n");
			  bw.write(sb.toString());
			    
			  // 가운데 공백 포함한 줄, 중앙 출력 후 종료
			  sb = new StringBuilder();
			  if (i != N) {
			      for(int j = 0; j < i; j++) {	// 왼쪽 외곽
					  sb.append("* ");
				  }
				  for(int j = 0; j < (col_size - 4*i); j++) {	// 가운데 공백
					  sb.append(" ");
				  }
				  for(int j = 0; j < i; j++) {	// 오른쪽 외곽
					  sb.append(" *");
				  }
				  sb.append("\n");
				  bw.write(sb.toString());
			  }
		  }
	
		  // 중앙 이후 빈줄 ~ 마지막
		  for (int i = N-1; i >= 1; i--){
			  sb = new StringBuilder();
			  // 가운데 공백 포함한 줄
			  for(int j = 0; j < i; j++) {
				 sb.append("* ");
			  }
			  for(int j = 0; j < (col_size - 4*i); j++) {
				  sb.append(" ");
			  }
			  for(int j = 0; j < i; j++) {
				  sb.append(" *");
			  }
			  sb.append("\n");
			  bw.write(sb.toString());
			  
			  // 가운데 별 포함한 줄  
			  sb = new StringBuilder();
			  for(int j = 0; j < (i-1); j++) {
				  sb.append("* ");
			  }
			  for(int j = 0; j < (col_size - 4*(i-1)); j++) {
				  sb.append("*");
			  }
			  for(int j = 0; j < (i-1); j++) {
				  sb.append(" *");
			  }
			  sb.append("\n");
			  bw.write(sb.toString());
			    
		  }
		     
		  bw.flush();
	  }
}
