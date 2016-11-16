package dinis.demidenko;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by dende on 15.11.2016.
 */
public class DataBase {

    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/social";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "0000";
    static Connection con;

    public Connection createCon(){
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Er1");
            e.printStackTrace();
        }
        return con;
    }
    public void addLogin(String log, String pass){
        try {
            Statement st = createCon().createStatement();
            st.execute("insert into idPass values('" + log + "', '" + pass +"');");
        } catch (SQLException e) {
            System.out.println("Er2");
            e.printStackTrace();
        }

    }
    public void addParam(String log, String name, String surname,
                         String age, String country){
        try {
            Statement st = createCon().createStatement();
            st.execute("insert into param values('" + log + "', '" + name + "', '" + surname +
            "', '" + age + "', '" + country + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

