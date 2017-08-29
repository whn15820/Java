package io.ntzyz.mybatis.pojo;

public class User {
    public String Username;
    public String Password;
    public int UserID;

    public User(String username, String password) {
        Username = username;
        Password = password;
        UserID = -1;
    }

    public User(int userID, String username, String password) {
        Username = username;
        Password = password;
        UserID = userID;
    }

    public String toString() {
        return "User { id: " + UserID + ", username: \"" + Username +"\", password: \"" + Password + "\" }";
    }
}
