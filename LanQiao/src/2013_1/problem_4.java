import java.util.ArrayList;

public class problem_4 {

    public static void main(String[] args) {
        System.out.println(reverse("1958"));
        ArrayList<price> a1 = new ArrayList<price>();
        ArrayList<price> a2 = new ArrayList<price>();

        for (int i = 1000; i <= 9999; i++) {
            String s = "" + i;
            if (s.contains("3") || s.contains("4") || s.contains("7")) {
                continue;
            }
            String re_s = reverse(s);
            int i1 = Integer.parseInt(re_s);
            int plus = i1 - i;
            if (plus < -200 && plus > -300)
                a1.add(new price(i, plus));
            if (plus < 900 && plus > 800)
                a2.add(new price(i, plus));
        }

        for (price p1 : a1
        ) {
            for (price p2 : a2
            ) {
                System.out.println(p1.pri + " " + p1.plus);
                System.out.println(p2.pri + " " + p2.plus);
            }
        }

    }

    private static String reverse(String s) {
        char[] ans = new char[s.length()];
        for (int i = s.length() - 1, j = 0; i >= 0; i--, j++) {
            char c = s.charAt(i);
            if (c == '6') ans[j] = '9';
            else if (c == '9') ans[j] = '6';
            else ans[j] = c;
        }
        return new String(ans);
    }

    private static class price {
        int pri;
        int plus;

        public price(int pri, int plus) {
            this.pri = pri;
            this.plus = plus;
        }
    }
}
