import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StaticSETofInts;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Whitelist {
    public static void main(String[] args) {
//        int[] w= In.readInts(args[0]);
//        StaticSETofInts set = new StaticSETofInts(w);
//        while (!StdIn.isEmpty()) {
//            //读取键，如果不再白名单中则打印它
//            int key = StdIn.readInt();
//            if (!set.contains(key)) {
//                StdOut.println(key);
//            }
//        }
        String str = "0002";
        int num = Integer.parseInt(str);
        System.out.println(num);
        String str1 = "1231.2";
        System.out.println(str.split("\\.",2)[0]);
        int num1 = Integer.parseInt(str.split("\\.",2)[0]);
        System.out.println(num);
        System.out.println(str.split("\\.").length);
    }
}
