package employee.management.system;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        String url = "jdbc:mysql://localhost:3306/employeemanagementsystem";
        String username = "root";
        String pwd = "prawin";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(url, username, pwd);
            s = c.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
