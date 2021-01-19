public class Vector {
    private final double[] coords;

    public Vector(double[] a){
        coords=a;
    }

//    public static void main(String[] args) {
//        double[] a={3.0,4.0};
//        Vector vector = new Vector(a);
//        a[0] = 0.0;
//        System.out.println(vector.coords[0]);
//        System.out.println(vector.coords[1]);
//    }
}

class A{
    private int a=1;
    private int b=2;

    public void A(int i){
        a=i;
    }
}

class B extends A{
    public static void main(String[] args) {
        B sim = new B();
        System.out.println(sim.b);
    }

//    private int b = 3;

}
