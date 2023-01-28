import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class kh21942 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String DDDhhmm = st.nextToken();
        int L = Integer.parseInt(DDDhhmm.substring(0, 3)) * 24 * 60 + Integer.parseInt(DDDhhmm.substring(4, 6)) * 60 + Integer.parseInt(DDDhhmm.substring(7, 9));
        int F = Integer.parseInt(st.nextToken());

        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 1; i < days.length; i++) {
            days[i] += days[i - 1];
        }
        TreeMap<String, Integer> tm = new TreeMap<>();
        TreeMap<String, Long> fines = new TreeMap<>();
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            String yyyyMMdd = st.nextToken();
            String hhmm = st.nextToken();
            int MM = Integer.parseInt(yyyyMMdd.substring(5, 7));
            int dd = (Integer.parseInt(yyyyMMdd.substring(8, 10)) - 1) + days[MM - 1];
            int hh = Integer.parseInt(hhmm.substring(0, 2)) + dd * 24;
            int mm = Integer.parseInt(hhmm.substring(3, 5)) + hh * 60;
            String P = st.nextToken();
            String M = st.nextToken();

            if (tm.containsKey(M + " " + P)) {
                int time = tm.remove(M + " " + P);
                if (time + L < mm) {
                    fines.put(M, fines.getOrDefault(M, 0L) + (mm - (time + L)) * F);
                }
            } else {
                tm.put(M + " " + P, mm);
            }
        }

        if (fines.isEmpty()) {
            bw.write("-1");
        } else {
            for (Map.Entry<String, Long> entry : fines.entrySet()) {
                bw.write(entry.getKey() + " " + entry.getValue() + "\n");
            }
        }

        bw.flush();
    }
}