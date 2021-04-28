public class Test {
    public static void main(String[] args) {
        B a = new B();
        String str = "l";
        a.nww(str);
    }
}

class A{
    int i;
    public void nww(String a){
        System.out.println("A");
    }
}

class B extends A{
    public void nww(int a) {
        System.out.println("B");
    }
}