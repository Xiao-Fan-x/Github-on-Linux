public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Member memberA = new Member("xiaofan",16);
        Member memberB = (Member) memberA.clone();
        System.out.println(memberA.toString());
        System.out.println(memberB.toString());
    }
}

class Member implements Cloneable{
    private String name;
    private int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString()+
                " Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
