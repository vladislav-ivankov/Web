package by.ivankov.web.dao.impl;

import by.ivankov.web.dao.BaseDao;
import by.ivankov.web.dao.UserDao;
import by.ivankov.web.entiry.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.intellij.lang.annotations.Language;

import java.sql.*;
import java.util.List;
import java.util.Properties;

public class UserDaoImpl implements UserDao, BaseDao<User> {
    static Logger logger = LogManager.getLogger();
    private static UserDaoImpl instance = new UserDaoImpl();
    private UserDaoImpl(){
    }

    public static UserDaoImpl getInstance() {
        return instance;
    }

    @Override
    public boolean insert(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public List<User> findAll(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean authenticate(String login, String password) {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            logger.info(e.getMessage() + e.getSQLState());
        }
        String url = "jdbc:mysql://localhost:3306/dbtest";
        Properties prop = new Properties();
        prop.put("user", "space");
        prop.put("password", "0963578");

        boolean result = false;
        try (Connection connection = DriverManager.getConnection(url, prop);
             Statement statement = connection.createStatement()) {
            @Language("SQL")
            String sql = "SELECT password FROM users WHERE name'" + login + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            String passFromDb;
            if (resultSet.next()) {
                passFromDb = resultSet.getString(1);
                result = password.equals(passFromDb);
            }
        } catch (SQLException e) {
            logger.info(e.getMessage() + e.getSQLState());
        }
        return result;
    }
}
