import com.mysql.cj.MysqlConnection;
import com.mysql.cj.jdbc.*;
import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {

        Connection conn = null;

        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "123456";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);
            System.out.println(conn.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conn = null;
            }
        }

    }
}


//        Map<String, String> map = new HashMap<String, String>();
//        map.put("hollis", "hollischuang");
//
//        Class<?> mapType = map.getClass();
//        Method capacity = mapType.getDeclaredMethod("capacity");
//        capacity.setAccessible(true);
//        System.out.println("capacity : " + capacity.invoke(map));
//
//        Field size = mapType.getDeclaredField("size");
//        size.setAccessible(true);
//        System.out.println("size : " + size.get(map));



