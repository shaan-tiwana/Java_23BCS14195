import java.sql.*;

public class JavaFinal {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String pass = "1234";


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);
        String query = "SELECT * FROM employee";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        System.out.println("Employee Records:");
        System.out.println("----------------------------");

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int salary = rs.getInt("salary");

            System.out.println(id + "   " + name + "   " + salary);
            
        rs.close();
        stmt.close();
        con.close();

    }
}


