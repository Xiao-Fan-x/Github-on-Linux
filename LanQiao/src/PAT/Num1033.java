package PAT;

import java.util.Scanner;

public class Num1033 {

    public static void main(String[] args) {
        StringBuffer result = new StringBuffer();
        Scanner input = new Scanner(System.in);
        String broken = input.nextLine();
        String unBroken = input.nextLine();

        if (broken.contains("+")) {
            unBroken = unBroken.replaceAll("[A-Z]", "");
        }

        for (int i = 0; i < unBroken.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < broken.length(); j++) {
                if (String.valueOf(unBroken.charAt(i)).toUpperCase()
                        .equals(String.valueOf(broken.charAt(j)).toUpperCase())) {
                    flag = false;
                    break;
                }
            }

            if (flag == true) {
                result.append((String.valueOf(unBroken.charAt(i))));
            }
        }

        System.out.println(result);
    }

}
