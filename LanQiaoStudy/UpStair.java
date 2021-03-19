import java.util.Scanner;

public class UpStair {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int res = f(num);
        System.out.println(res);
    }

    public static int f(int num) {

        if (num <= 0) return 0;
        if (num == 1) return 1;
        if (num == 2) return 2;
        if (num == 3) return 4;

        return f(num - 1) + f(num - 2) + f(num - 3);

    }
}
