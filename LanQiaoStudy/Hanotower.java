import java.util.Scanner;

public class Hanotower {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        hanno(num, "A", "B", "C");
    }

    public static void hanno(int num, String from, String help, String to) {
        if (num == 1) {
            System.out.println("move " + num + "from" + from + "to" + to);
            return;
        }

        hanno(num - 1, from, to, help);
        System.out.println("move " + num + "from" + from + "to" + to);
        hanno(num - 1, help, from, to);
    }
}
