import java.util.UUID;

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(UUID.randomUUID());
        UUID uid = UUID.randomUUID();
        System.out.println(uid);
        System.out.println(uid.toString());
    }
}
