package io.ntzyz.mybatis.jdbc;

import javax.xml.transform.Result;
import java.sql.*;
import io.ntzyz.mybatis.pojo.*;

/**
 * create table user (
 *   id int primary key auto_increment,
 *   username varchar(50) unique key not null,
 *   password varchar(64) not null
 * );
 */
public class TestJDBC {
    public static void main(String[] args) {
        Connection connecion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return;
        }

        try {
            connecion = DriverManager.getConnection("jdbc:mysql://localhost:3306/shitty?characterEncoding=utf-8", "root", "");
        } catch (SQLException ex) {
            ex.printStackTrace();
            return;
        }

        String sql = "SELECT * FROM user";
        try {
            ps = connecion.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                User user = new User(id, username, password);
                System.out.println(user.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }
}
