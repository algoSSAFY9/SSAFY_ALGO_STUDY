package algoStudy.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * [단어 뒤집기2]
 * 1. 소문자 알파벳, 숫자, 공백, 특수문자
 * 2. 문자열 시작과 끝은 공백이 아님
 * 3. < > 안에는 소문자 알파벳과 공백만 있음
 * 단어 = 알파벳 + 숫자
 * 연속하는 두 단어는 공백 하나로 구분
 * 
 * 문장이 아닌 단어를 뒤집어서 출력
 * 태그 안은 그대로
 */
public class BS9_17413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder rev;
		
		String str = br.readLine();
		
		int pre=0, next=-1;
		boolean isTag =false;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='<') {
				pre=i;
				if(!isTag) {
					for(String s : str.substring(next+1, pre).split(" ")) {
						rev = new StringBuilder(s).reverse();
						sb.append(rev).append(' ');
					}
					sb.delete(sb.length()-1, sb.length());
				}
				isTag=true;
			}
			else if(str.charAt(i)=='>') {
				next=i;
				sb.append(str.substring(pre, next+1));
				isTag=false;
			}
		}
		
		for(String s : str.substring(next+1, str.length()).split(" ")) {
			rev = new StringBuilder(s).reverse();
			sb.append(rev).append(' ');
		}
		sb.delete(sb.length()-1, sb.length());
		
		System.out.println(sb);
	}
}
