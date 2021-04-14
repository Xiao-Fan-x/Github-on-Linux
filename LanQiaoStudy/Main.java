import java.util.Scanner;


/**
 * 输入格式:
 * 输入第1行给出正整数n（≤10）；第2行给出n个整数，其间以空格分隔。
 *
 * 输出格式:
 * 在一行中输出第一次出现的最长连续递增子序列，数字之间用空格分隔，序列结尾不能有多余空格。
 *
 * 15
 * 1 9 2 5 7 3 4 6 8 0 11 15 17 17 10
 */
public class Main {
    public static void main(String[] args) {

        //输入
        Scanner sr = new Scanner(System.in);
        int n = Integer.parseInt(sr.nextLine());
        int[] res = new int[n];
        String s[] = sr.nextLine().split(" ");
        for (int i = 0; i < n; i++)
            res[i] = Integer.parseInt(s[i]);


        int max = 0, count = 0, ss = 0, x = 0, y = 0;
        for (int i = 0; i < n - 1; i++) {
            y = i + 1;//判断是否递增，是的话count++;
            if (res[i + 1] > res[i]) {
                count++;
                if (count > max) {
                    max = count;
                    ss = x;
                }
            } else {
                count = 0;
                x = y;//不连续递增，则索引改变为下一个目标
            }
        }

        for (int i = ss; i <= ss + max; i++) {
            if (i == (ss + max)) {
                System.out.print(res[i]);
            } else {
                System.out.print(res[i] + " ");
            }
        }
    }

}
