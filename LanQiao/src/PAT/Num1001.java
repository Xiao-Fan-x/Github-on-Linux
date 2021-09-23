package PAT;

import java.util.Scanner;

public class Num1001 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        int[] arr = new int[num];
        int index = 0;
        int max = 0;

        for (int i = 0; i < num; i++) {
            arr[i] = 0;
        }
        int a, b;
        while (num > 0) {
            a = input.nextInt();
            b = input.nextInt();

            arr[a - 1] += b;
            num--;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i + 1;
            }
        }
        System.out.println(index + " " + max);
        input.close();
    }
}


//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int num = input.nextInt();
//        int n = -1;
//
//
//        int[][] array = new int[num][2];
//        for (int i = 0; i < num; i++) {
//            array[i][0] = input.nextInt();
//            array[i][1] = input.nextInt();
//        }
//
//        for (int i = 0; i < num; i++) {
//            int a = array[i][0];
//            int b = array[i][1];
//
//            for (int j = i + 1; j < num; j++) {
//                if (array[j][0] == a) {
//                    b += array[j][1];
//                    array[j][1] = -1;
//                }
//            }
//            array[i][1] = b;
//        }
//        int max = -1;
//        int maxnum = -1;
//        for (int i = 0; i < num; i++) {
//            if (array[i][1] > max) {
//                max = array[i][1];
//                maxnum = array[i][0];
//            }
//        }
//
//        System.out.print(maxnum+" "+max);
//        input.close();
//    }
//}