import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class hjy1620 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());	// 도감 등록 수
		int m = Integer.parseInt(st.nextToken());	// 맞출 문제 수
		
		HashMap<Integer, String> IS_map = new HashMap<>();	// 	idx , 이름 순서로 저장하는 해시맵
        HashMap<String, Integer> SI_map = new HashMap<>();	//	이름, idx 순서로 저장하는 해시맵

        // 도감 등록 수 만큼 반복
        for (int i = 1; i < n + 1; i++) {	// 도감 번호 1번부터 시작
            String str = br.readLine();	// 포켓몬 이름
            IS_map.put(i, str);			// idx , 이름 순서로 저장
            SI_map.put(str, i);			// 이름, idx 순서로 저장
        }
        // 문제 개수만큼 for문
        for (int i = 1; i <= m; i++) {
            String problem = br.readLine();
            // 읽은 값이 숫자인 경우 : 해당하는 이름 출력
            if(isNum(problem)){
                sb.append(IS_map.get(Integer.parseInt(problem))+"\n");
            }
            // 읽은 값이 이름인 경우 : 해당하는 idx 출력
            else{
                sb.append(SI_map.get(problem)+"\n");
            }
        }

        System.out.println(sb);
    }

	// 읽어온 문제가 숫자인지 문자열인지 판단
    public static boolean isNum(String str) {
        // 문자열에 숫자 포함되었는지 확인
    	for (int i = 0; i < str.length(); i++) {
    		// 문자가 숫자가 아닐 경우
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
