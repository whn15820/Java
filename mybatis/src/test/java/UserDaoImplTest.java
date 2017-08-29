import java.sql.*;
import java.util.*;
import io.ntzyz.mybatis.dao.*;
import io.ntzyz.mybatis.dao.impl.*;
import io.ntzyz.mybatis.pojo.*;

public class UserDaoImplTest {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();

        System.out.println("## Initial state:");
        List<User> users = userDao.ListAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
        System.out.println("");

        System.out.println("## After insert:");
        User newUser = new User("lover", "fuckhere");
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
