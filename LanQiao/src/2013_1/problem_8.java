/*8.标题：带分数

        100 可以表示为带分数的形式：100 = 3 + 69258 / 714

        还可以表示为：100 = 82 + 3546 / 197

        注意特征：带分数中，数字1~9分别出现且只出现一次（不包含0）。

        类似这样的带分数，100 有 11 种表示法。

        题目要求：
        从标准输入读入一个正整数N (N<1000*1000)
        程序输出该数字用数码1~9不重复不遗漏地组成带分数表示的全部种数。
        注意：不要求输出每个表示，只统计有多少表示法！


        例如：
        用户输入：
        100
        程序输出：
        11

        再例如：
        用户输入：
        105
        程序输出：
        6


        资源约定：
        峰值内存消耗（含虚拟机） < 64M
        CPU消耗  < 3000ms
*/
import java.util.Scanner;

public class problem_8 {

    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr = {1,2,3};
        f(arr,0);
        System.out.println("");
    }

    private static void f(int[] arr, int k) {
        if (k == 9) {
//            ans++;
            print(arr);

        }
        for (int i=0; i<arr.length;i++){
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;

            f(arr,k-1);

            temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
    }

    private static void print(int[] arr) {
        for (int i = 0; i< arr.length;i++){
            System.out.println(arr[i]);
        }
        System.out.println();
    }

}
