package by.ivankov.web.dao;

public interface UserDao {
    boolean authenticate(String login, String password);
}
