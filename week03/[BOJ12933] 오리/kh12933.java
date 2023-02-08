import java.io.*;

public class kh12933 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String record = br.readLine();
        int[] sound = new int[5];
        boolean isValid = true;
        int ans = 0;
        for (int i = 0; i < record.length(); i++) {
            switch (record.charAt(i)) {
                case 'q':
                    sound[0]++;
                    break;
                case 'u':
                    if (sound[0] > sound[1]) sound[1]++;
                    else isValid = false;
                    break;
                case 'a':
                    if (sound[1] > sound[2]) sound[2]++;
                    else isValid = false;
                    break;
                case 'c':
                    if (sound[2] > sound[3]) sound[3]++;
                    else isValid = false;
                    break;
                case 'k':
                    if (sound[3] > sound[4]) {
                        ans = Math.max(ans, sound[0] - sound[4]);
                        sound[4]++;
                    } else isValid = false;
                    break;
            }

            if (!isValid) break;
        }

        for (int s : sound) {
            if (s != record.length() / 5) {
                isValid = false;
                break;
            }
        }

        bw.write(String.valueOf(isValid ? ans : -1));
        bw.flush();
    }
}
