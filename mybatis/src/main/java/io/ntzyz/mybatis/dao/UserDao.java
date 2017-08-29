package io.ntzyz.mybatis.dao;

import io.ntzyz.mybatis.pojo.*;
import java.util.List;

public abstract class UserDao {
    public static enum FILTER_MODE {
        BY_USERID,
        BY_USERNAME,
        BY_USERID_OR_USERNAME,
    };

    /**
     * Add one user to database
     * @param user The user to add
     * @return whether succeed or not.
     */
    abstract public boolean AddUser(User user);

    /**
     * List all users in database
     * @return An ArrayList of User
     */
    abstract public List<User> ListAll();

    /**
     * Remove one user from database
     * @param param Value to locate the user to remove
     * @param mode Key to locate the user to remove
     * @return count of affected rows.
     */
    abstract public int RemoveUser(Object param, FILTER_MODE mode);

    /**
     * Remove one user from database by it's UserID
     * @param id ID for the user.
     * @return count of affected rows
     */
    public int RemoveUserById (int id) {
        return RemoveUser(id, FILTER_MODE.BY_USERID);
    }

    /**
     * Remove one user from database by it's Username
     * @param username name for the user
     * @return count of affected rows
     */
    public int RemoveUserByUsername (String username) {
        return RemoveUser(username, FILTER_MODE.BY_USERNAME);
    }

    /**
     * Remove one user from database by it's username or userid, use with caution!
     * @param param UserID or Username for the user.
     * @return count of affected rows.
     */
    public int RemoveUser (Object param) {
        return RemoveUser(param, FILTER_MODE.BY_USERID_OR_USERNAME);
    }

    /**
     * Find one user from database
     * @param param Value to locate the user to find
     * @param mode Key to locate the user to find
     * @return user found or null if not exist.
     */
    abstract public User FindUser (Object param, FILTER_MODE mode);

    /**
     * Find one user from database by it's UserID
     * @param id UserID or Username for the user.
     * @return user found or null if not exist.
     */
    public User FindUserById (int id) {
        return FindUser(id, FILTER_MODE.BY_USERID);
    }

    /**
     * Find one user from database by it's Username
     * @param username username or Username for the user.
     * @return user found or null if not exist.
     */
    public User FindUserByUsername (String username) {
        return FindUser(username, FILTER_MODE.BY_USERNAME);
    }

    /**
     * Find one user from database by it's username or userid.
     * @param param UserID or Username for the user.
     * @return user found or null if not exist.
     */
    public User FindUser (Object param) {
        return FindUser(param, FILTER_MODE.BY_USERID_OR_USERNAME);
    }

    /**
     * Update user by it id (in object)
     * @param user User info to update
     * @return affected rows
     */
    abstract public int UpdateUser (User user);
}
