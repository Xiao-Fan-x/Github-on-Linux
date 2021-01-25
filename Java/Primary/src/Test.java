import edu.princeton.cs.algs4.StdDraw;

public class Test {

    {
        System.out.println("普通代码块");
    }

    public Test(){

        {
            System.out.println("构造块");
        }

        System.out.println("构造方法");
    }

    {
        System.out.println("普通代码块2");
    }

    public static void main(String[] args) {
        new Test();
        new Test();
        new Test();

    }



}