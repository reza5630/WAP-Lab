import java.sql.*;

public class DbConnection {

    public static void main(String[] args) {
        getConnection();
    }

    public static Connection getConnection() {
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName); // here is the ClassNotFoundException

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/entries", "root", "root");

/*            //here sonoo is database name, root is username and password
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from entries");
            while (rs.next())
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            conn.close();*/
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
