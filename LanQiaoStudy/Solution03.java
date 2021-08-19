import java.util.Arrays;
import java.util.Scanner;

public class Solution03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine());
        int[] arr = new int[num];
        String[] res = input.nextLine().split(" ");
        for (int i = 0; i < res.length; i++) {
            arr[i] = Integer.parseInt(res[i]);
        }
        int[] dp = new int[num];

        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] <= arr[i]) {
                    int temp = dp[j];
                    max = Math.max(max, temp);
                }
            }
            dp[i] = max + 1;
        }
        for (int i = 0; i < num; i++) {
            System.out.print(dp[i] + " ");

        }

    }
}
