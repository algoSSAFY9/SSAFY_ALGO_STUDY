import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//import java.util.PriorityQueue;

public class kbs4358 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); //answer
		
		Map<String,Integer> hm = new HashMap<>();
//		PriorityQueue<String> pq = new PriorityQueue<>();
		int total = 0;
		while(true) {
			String name = br.readLine();
			if(name==null || name.equals("")) break;
			
			hm.put(name, hm.getOrDefault(name, 0)+1);
			// getOrDefault(key, DefaultValue): 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환하는 메서드
//			if(!pq.contains(name)) pq.add(name);
			total++;
		}

		Object[] keys = hm.keySet().toArray();
		Arrays.sort(keys);
		
		for(Object key: keys){
//			String name = pq.poll();
			String name = (String)key;
			double percent = ((double)hm.get(name)/(double)total )*100;
			sb.append(name).append(" ").append(String.format("%.4f", percent)).append("\n");
			
		}
		System.out.println(sb);
		
		
	}

}
