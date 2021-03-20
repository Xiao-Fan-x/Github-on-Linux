public class Fanchon {

    public static void main(String[] args) {
        System.out.println(reserve("abcd",3));
    }

    public static String reserve(String sp prc, int end){
        if (end == 0) return ""+ src.charAt(0);
        return src.charAt(end)+reserve(src,end-1);
    }
}
