package io.ntzyz.mybatis.dao.impl;

import io.ntzyz.mybatis.dao.UserDao;
import io.ntzyz.mybatis.jdbc.DbTools;
import io.ntzyz.mybatis.pojo.User;
import java.sql.*;
import java.util.*;

public class UserDaoImpl extends UserDao {
    public boolean AddUser(User user) {
        return DbTools.ExecuteInsert("INSERT INTO user(username, password) VALUES(?, ?)", new Object[]{ user.Username, user.Password });
    }

    public List<User> ListAll() {
        ResultSet rs = DbTools.ExecuteQuery("SELECT * FROM user", new Object[]{});
        List<User> res = new ArrayList<User>();

        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                res.add(new User(id, username, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return res;
    }

    public int RemoveUser(Object param, FILTER_MODE mode) {
        switch (mode) {
            case BY_USERID:
                return DbTools.ExecuteUpdate("DELETE FROM user WHERE id = ?", new Object[] { param });
            case BY_USERNAME:
                return DbTools.ExecuteUpdate("DELETE FROM user WHERE username = ?", new Object[] { param });
            case BY_USERID_OR_USERNAME:
                return DbTools.ExecuteUpdate("DELETE FROM user WHERE username = ? OR id = ?", new Object[] { param, param });
        }
        return -1;
    }

    public User FindUser(Object param, FILTER_MODE mode) {
        ResultSet rs = null;
        User result = null;
        switch (mode) {
            case BY_USERID:
                rs = DbTools.ExecuteQuery("SELECT * FROM user WHERE id = ?", new Object[] { param });
                break;
            case BY_USERNAME:
                rs = DbTools.ExecuteQuery("SELECT * FROM user WHERE username = ?", new Object[] { param });
                break;
            case BY_USERID_OR_USERNAME:
                rs = DbTools.ExecuteQuery("SELECT * FROM user WHERE username = ? OR id = ?", new Object[] { param, param });
                break;
        }

        try {
            if (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                result = new User(id, username, password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    public int UpdateUser(User user) {
        return DbTools.ExecuteUpdate("UPDATE user SET username = ?, password = ? WHERE id = ?", new Object[] { user.Username, user.Password, user.UserID });
    }
}
