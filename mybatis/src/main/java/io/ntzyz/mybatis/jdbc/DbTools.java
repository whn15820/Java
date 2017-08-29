package io.ntzyz.mybatis.jdbc;

import java.sql.*;

public class DbTools {
    private static final String __driver = "com.mysql.jdbc.Driver";
    private static final String __url = "jdbc:mysql://localhost:3306/shitty";
    private static final String __user = "root";
    private static final String __pass = "";

    private static Connection connection = null;
    private static ResultSet rs = null;
    private static PreparedStatement ps = null;

    static {
        try {
            Class.forName(__driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void GetConnection () {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(__url, __user, __pass);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void CloseAll () {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void InitializeStatement (String sql, Object[] params) throws SQLException {
        ps = connection.prepareStatement(sql);
        if (params != null) {
            for (int i = 0; i != params.length; ++i) {
                ps.setObject(i + 1, params[i]);
            }
        }
    }

    public static ResultSet ExecuteQuery (String sql, Object[] params) {
        GetConnection();

        try {
            InitializeStatement(sql, params);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    public static boolean ExecuteInsert (String sql, Object[] params) {
        boolean hasError = false;

        GetConnection();

        try {
            InitializeStatement(sql, params);
            hasError = ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hasError;
    }

    public static int ExecuteUpdate (String sql, Object[] params) {
        int affectedRows = -1;

        GetConnection();

        try {
            InitializeStatement(sql, params);
            affectedRows = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectedRows;
    }
}
