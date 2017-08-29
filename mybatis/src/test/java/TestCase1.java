import java.sql.*;
import java.util.*;
import io.ntzyz.mybatis.dao.*;
import io.ntzyz.mybatis.dao.impl.*;
import io.ntzyz.mybatis.pojo.*;

/**
 * 查询单个用户实现测试
 */
public class TestCase1 {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.FindUser("a");
        if (user != null) {
            System.out.println(user.toString());
        } else {
            System.out.println("undefined");
        }
    }
}
