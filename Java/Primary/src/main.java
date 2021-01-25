public class main {

    public static void main(String[] args) {
        float x = 10.1F;
        float y = 10.2F;
        System.out.println(x * y);

        char a = 'a';
        int b = a;
        System.out.println("a = " + b);

        a = 'z';
        b = a;
        System.out.println("z = " + b);

        a = 'A';
        b = a;
        System.out.println("A = " + b);

        a = 'Z';
        b = a;
        System.out.println("Z = " + b);

        a = '0';
        b = a;
        System.out.println("0 = " + b);

        a = '9';
        b = a;
        System.out.println("9 = " + b);

        int num = 3;
        String str = "nihao" + num;
        System.out.println(str);
        System.out.println(num * 2);
    }
}
