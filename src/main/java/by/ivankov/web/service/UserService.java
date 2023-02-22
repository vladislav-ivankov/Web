package by.ivankov.web.service;

public interface UserService {
    boolean authenticate(String login, String password);
}
