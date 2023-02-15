import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class kh1697 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Data> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(new Data(N, 0));
        while (true) {
            Data d = queue.poll();

            if (d.location == K) {
                bw.write(String.valueOf(d.time));
                break;
            }

            if (K < d.location) {
                if (!visited.contains(d.location - 1)) {
                    queue.offer(new Data(d.location - 1, d.time + 1));
                    visited.add(d.location - 1);
                }
            } else {
                if (d.location > 0 && !visited.contains(d.location - 1)) {
                    queue.offer(new Data(d.location - 1, d.time + 1));
                    visited.add(d.location - 1);
                }
                if (!visited.contains(d.location + 1)) {
                    queue.offer(new Data(d.location + 1, d.time + 1));
                    visited.add(d.location + 1);
                }
                if (!visited.contains(d.location * 2)) {
                    queue.offer(new Data(d.location * 2, d.time + 1));
                    visited.add(d.location * 2);
                }
            }
        }

        bw.flush();
    }
}

class Data {
    int location;
    int time;

    Data(int location, int time) {
        this.location = location;
        this.time = time;
    }
}
