import java.sql.*;
import java.util.*;
import io.ntzyz.mybatis.dao.*;
import io.ntzyz.mybatis.dao.impl.*;
import io.ntzyz.mybatis.pojo.*;

/**
 * 所有数据查询测试+插入测试+删除测试
 */
public class TestCase4 {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();

        System.out.println("## Initial state:");
        List<User> users = userDao.ListAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
        System.out.println("");

        System.out.println("## After insert:");
        User newUser = new User("233", "666");
        userDao.AddUser(newUser);
        users = userDao.ListAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
        System.out.println("");

        System.out.println("## After remove:");
        userDao.RemoveUser("lover", UserDao.FILTER_MODE.BY_USERNAME);
        users = userDao.ListAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
        System.out.println("");
    }
}
