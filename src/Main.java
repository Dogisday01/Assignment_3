import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;
public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);        System.out.print("Enter user name: ");
        String name = in.next();        System.out.print("Enter password: ");
         int pass = in.nextInt();        System.out.print("Enter balance: ");
        final int balance = in.nextInt();
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_user_table","root","0000");

            String sql = "INSERT INTO db_user_name (DB_USER_NAME, DB_USER_password, DB_USER_BALANCE) VALUES (?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, pass);
            statement.setInt(3, balance);
            int rowsInserted = statement.executeUpdate();            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");            }

        }catch (Exception e){            e.printStackTrace();
        }
    }}