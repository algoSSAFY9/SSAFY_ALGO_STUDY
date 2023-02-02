import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class hjw21942 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); 
		String[] l = st.nextToken().split("/|:"); // 대여 기간
		int deadline = Integer.parseInt(l[0]) * 24 * 60 + Integer.parseInt(l[1]) * 60 + Integer.parseInt(l[2]);
		int money = Integer.parseInt(st.nextToken()); // 벌금

		HashMap<String, String> map = new HashMap<>(); // 대여
		TreeMap<String, Long> tmap = new TreeMap<>(); // 벌금 리스트
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String date = st.nextToken() + " " + st.nextToken();
			String pn = st.nextToken(); // 부품
			String nick = st.nextToken(); // 닉네임
			
			String pt = pn + " " + nick;
			if(map.containsKey(pt)) {
				long one = f.parse(date).getTime();
				long two = f.parse(map.get(pt)).getTime();
				long sec = ((one - two) / 60000);
				
				if(sec > deadline) {
					if(tmap.containsKey(nick)) tmap.put(nick, tmap.get(nick) + (sec - deadline) * money);
					else tmap.put(nick, (sec - deadline) * money);
				}
				map.remove(pt);
			}
			else {
				map.put(pt, date);
			}
		}

		if(tmap.isEmpty()) {
			System.out.println(-1);
			System.exit(0);
		}
		
		StringBuilder sb = new StringBuilder();
		
		int size = tmap.size();
		for(int i=0; i<size; i++) {
			sb.append(tmap.firstKey()).append(" ").append(tmap.get(tmap.firstKey())).append("\n");
			tmap.pollFirstEntry();
		}
		
		System.out.println(sb.toString());
	}
}

