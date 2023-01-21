package work3;

import java.sql.*;


public class workTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nwafu?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","122600");
            //1.
            PreparedStatement stmt = conn.prepareStatement("update nwafu.scorelist set score = 83 where stuname = ?");
            stmt.setString(1,"张强");
            stmt.executeUpdate();
            //2.
            PreparedStatement sql = conn.prepareStatement("select score from nwafu.scorelist where course = ?");
            sql.setString(1, "数据结构");
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
