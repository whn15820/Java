import java.sql.*;
import java.util.*;
import io.ntzyz.mybatis.dao.*;
import io.ntzyz.mybatis.dao.impl.*;
import io.ntzyz.mybatis.pojo.*;

/**
 * 查询用户测试+模拟登陆
 */
public class TestCase3 {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter your username: ");
        String username = reader.nextLine().trim();

        System.out.println("Enter your password: ");
        String password = reader.nextLine().trim();

        User user = userDao.FindUserByUsername(username);

        if (user == null) {
            System.out.println("User not exist!");
            return;
        } else if (!user.Password.equals(password)) {
            System.out.println("Login incorrect!");
            return;
        } else {
            System.out.println("Welcome!");
        }

        System.out.println("Enter your new username: ");
        user.Username = reader.nextLine().trim();

        System.out.println("Enter your new password: ");
        user.Password = reader.nextLine().trim();

        userDao.UpdateUser(user);
        System.out.println("Update done.");
    }
}
