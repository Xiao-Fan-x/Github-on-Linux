import java.text.ParseException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException, ParseException {
        Scanner input = new Scanner(System.in);
        String v1 = input.next();
        String v2 = input.next();

        int res = compareVersion(v1, v2);
        System.out.println(res);
    }

    private static int compareVersion(String v1, String v2) {
        int turned = 1;
        int isZero = 1;
        int v1_length = v1.split("\\.").length;
        int v2_length = v2.split("\\.").length;

        if (v1_length < v2_length) {
            String temp = v1;
            v1 = v2;
            v2 = temp;
            turned = -1;
        }

        while (v2.split("\\.").length >= 2) {
            String v1_str[] = v1.split("\\.", 2);
            String v2_str[] = v2.split("\\.", 2);

            int v1num = Integer.valueOf(v1_str[0]);
            int v2num = Integer.valueOf(v2_str[0]);

            if (v1num > v2num) {
                return 1;
            } else if (v1num < v2num) {
                return -1;
            }

            v1 = v1_str[1];
            v2 = v2_str[1];
        }

        String v1_str[] = v1.split("\\.", 2);
        if (v1_str[1] != null) {
            v1 = v1_str[1];
            char[] v1_str1 = v1.toCharArray();
            for (int i = 0; i < v1.length(); i++) {
                if (v1_str1[i] > '0' && v1_str1[i] < '9') isZero = -1;
            }

            if (isZero == 1) {
                int v1num = Integer.valueOf(v1_str[0]);
                int v2num = Integer.valueOf(v2);

                if (v1num > v2num) {
                    return 1 * turned;
                } else if (v1num < v2num) {
                    return -1 * turned;
                } else {
                    return 0;
                }
            }
        }

        int v1num = Integer.valueOf(v1);
        int v2num = Integer.valueOf(v2);

        if (v1num > v2num) {
            return 1 * turned;
        } else if (v1num < v2num) {
            return -1 * turned;
        }else return 0;
    }

}



