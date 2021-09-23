package PAT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        int[][] num = new int[n][2];
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            String[] s = in.readLine().split("\\s+");
            num[i][0] = Integer.parseInt(s[0]);
            num[i][1] = Integer.parseInt(s[1]);
            sum[i] = num[i][1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (num[i][0] == num[j][0]) {
                    sum[i] += num[j][1];
                }
            }
        }
        int max = 0;
        int flag = 0;
        int len = sum.length;
        for (int i = 0; i < len; i++) {
            if (sum[i] > max) {
                max = sum[i];
                flag = i;
            }
        }
        System.out.print(num[flag][0] + " " + max);
    }
}