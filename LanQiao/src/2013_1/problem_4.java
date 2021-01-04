import java.util.ArrayList;

public class problem_4 {

  public static void main(String[] args) {
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

    private static String reverse (String s){
      char[] ans = new char[s.length()];
      for (int i = s.length(); )

    }
  }
  private static class price {
    int pri;
    int plus;

  }
}
