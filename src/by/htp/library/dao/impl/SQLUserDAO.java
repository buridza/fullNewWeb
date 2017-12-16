package by.htp.library.dao.impl;

import by.htp.library.dao.UserDAO;
import by.htp.library.dao.exception.DAOException;
import by.htp.library.entity.User;

import java.sql.*;
import java.util.ArrayList;

public class SQLUserDAO implements UserDAO {
    private final String SQLURL = new String("jdbc:mysql://localhost/library");
    private final String SQL_USER = new String("root");
    private final String SQL_USER_PASSWORD = new String("123456");

    @Override
    public boolean register(User user) throws DAOException {
        try {
            Connection connection = DriverManager.getConnection(SQLURL, SQL_USER, SQL_USER_PASSWORD);
            Statement statement = connection.createStatement();
            //ResultSet resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User logination(String login, String password) throws DAOException {

        User user = null;
        try (
                Connection connection = DriverManager.getConnection(SQLURL, SQL_USER, SQL_USER_PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user WHERE login='" + login + "'AND password = '" + password + "'");

            resultSet.next();
            if (resultSet.getRow() != 0) {
                user = new User();
                // throw new SQLException("UserNotFound");
                user.setLogin(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
                user.setName(resultSet.getString(3));
                user.setSurname(resultSet.getString(4));
                user.setDob(resultSet.getString(5));
                user.setVip(resultSet.getBoolean(6));
                user.setBan(resultSet.getBoolean(7));
                boolean b = user.getPassword().equals(password);
                if (!b) {
                    user = null;
                }
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }

		/*user.setName("Ivan");
        user.setSurname("Ivanov");*/
        //throw new DAOException("vai vai vai");

        return user;
    }

    public static void main(String[] args) {
        SQLUserDAO sqlUserDAO = new SQLUserDAO();
        try {
            User user = sqlUserDAO.logination("Valiyha_96", "29121059");
            System.out.println(user);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList getAll(String login, String password) throws DAOException {
        ArrayList<User> arrayList = null; //new ArrayList<User>();
        User user = null;
        try (Connection connection = DriverManager.getConnection(SQLURL, SQL_USER, SQL_USER_PASSWORD)) {
            ;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM user WHERE login='" + login +
                            "'AND password = '" + password + "' AND adminAccess='" + 1+ "'");
            resultSet.next();
            if (resultSet.getRow() != 0) {
                arrayList = new ArrayList<User>();
            }
            resultSet = statement.executeQuery(
                    "SELECT * FROM user");
            if(arrayList!=null)
            while (resultSet.next()) {
                user = new User();
                user.setLogin(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
                user.setName(resultSet.getString(3));
                user.setSurname(resultSet.getString(4));
                user.setDob(resultSet.getString(5));
                user.setVip(resultSet.getBoolean(6));
                user.setBan(resultSet.getBoolean(7));
                arrayList.add(user);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return arrayList;
    }
}
