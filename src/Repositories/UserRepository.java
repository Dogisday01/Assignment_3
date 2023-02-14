package Repositories;



import java.sql.*;

public class UserRepository {

    private static String URL = "jdbc:mysql://localhost:3306/users";
    public static String CreateUser(String name,String pass,int balance){
        Connection con = null;
        String s = "";
        try{
            con = DriverManager.getConnection(URL,"root","6021");
            String sql = "INSERT INTO users_info  (user_name, user_pass, user_balance) VALUES (?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, name);
            pst.setString(2, pass);
            pst.setInt(3, balance);

            pst.execute();

            s = "A new user was inserted successfully!";
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return s;
    }

    public static String LogIn (String name, String pass){
        Connection con = null;
        String s = "";
        try{
            con = DriverManager.getConnection(URL,"root","6021");
            Statement st = con.createStatement();
            String sql = "SELECT * FROM users_info WHERE user_name='" + name + "' AND user_pass = '" + pass + "'";

            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                ;               s = "Welcome!";
            } else {
                s = "User name or password is not correct!";
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return s;
    }
    public static String deleteUser(String name,String pass) {
        Connection con = null;
        String s = "";
        try {
            con = DriverManager.getConnection(URL,"root","6021");
            String sql = "DELETE FROM users_info WHERE user_name=? AND user_pass = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2,pass);
            st.executeUpdate();
            s = "User successfully deleted ";
        } catch(Exception e){
            s = e.getMessage();
        }
        return s;
    }
    public static String showUsers(){
        Connection con = null;
        String s = "";
        try{
            con = DriverManager.getConnection(URL,"root","6021");
            String sql = "SELECT * FROM user_info";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                s = rs.getString("id") + rs.getString("user_name") + rs.getString("user_pass")+rs.getString("user_balance");
            }
        }catch(Exception e){
            e.getMessage();
        }
        return s;

    }


}

