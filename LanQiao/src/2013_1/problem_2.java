public class problem_2 {

    public static void main(String[] args) {
        int ans = f(0, 0);
        System.out.println(ans);
    }

    private static int f(int i, int j) {
        if (i == 3 || j == 4) {
            return 1;
        }
        return f(i, j + 1) + f(i + 1, j);
    }
}
