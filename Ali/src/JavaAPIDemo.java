import java.util.Arrays;

public class JavaAPIDemo{

    public static void main(String[] args) {
        BinaryTree<Person> tree = new BinaryTree<Person>();
        tree.add(new Person("小强-80",80));
        tree.add(new Person("小强-85",85));
        tree.add(new Person("小强-30",30));
        tree.add(new Person("小强-50",50));
        tree.add(new Person("小强-60",60));
        tree.add(new Person("小强-90",90));
        tree.add(new Person("小强-10",10));
        tree.add(new Person("小强-55",55));
        tree.add(new Person("小强-70",70));
        tree.add(new Person("小强-95",95));
        tree.remove(new Person("小强-10",10));
        System.out.println(Arrays.toString(tree.toArray()));
    }
}

class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }
}

