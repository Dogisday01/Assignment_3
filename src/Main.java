
import java.util.*;
import java.sql.*;
public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);        System.out.print("Enter user name: ");
        String name = in.next();        System.out.print("Enter password: ");
         String pass = in.next();        System.out.print("Enter balance: ");
         int balance = in.nextInt();
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_user_table","root","0000");

            String sql = "INSERT INTO db_user_name (DB_USER_NAME, DB_USER_password, DB_USER_BALANCE) VALUES (?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, pass);
            statement.setInt(3, balance);
            int rowsInserted = statement.executeUpdate();            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");            }

        }catch (Exception e){            e.printStackTrace();
        }
    }}