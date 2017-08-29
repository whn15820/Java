import java.sql.*;
import java.util.*;
import io.ntzyz.mybatis.dao.*;
import io.ntzyz.mybatis.dao.impl.*;
import io.ntzyz.mybatis.pojo.*;


public class TestCase2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Enter your username: ");
        String username = reader.nextLine().trim();

        System.out.println("Enter your password: ");
        String password = reader.nextLine().trim();

        UserDao userDao = new UserDaoImpl();
        User user = userDao.FindUserByUsername(username);

        if (user == null) {
            System.out.println("User not exist!");
        } else if (!user.Password.equals(password)) {
            System.out.println("Login incorrect!");
        } else {
            System.out.println("Welcome!");
        }
    }
}
