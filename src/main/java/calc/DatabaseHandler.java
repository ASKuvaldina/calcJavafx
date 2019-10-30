package calc;

import java.sql.*;

public class DatabaseHandler  {

    public void addHistoryDB(String res){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/calc?useUnicode=yes&characterEncoding=UTF-8&serverTimezone=UTC", "root", "vitaly");
            Statement stmt = con.createStatement();



        stmt.execute("INSERT INTO `historydb` (`operation`) VALUES ('"+res+"')\n");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
