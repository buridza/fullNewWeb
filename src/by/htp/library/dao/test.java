package by.htp.library.dao;

import by.htp.library.dao.exception.DAOException;

import java.sql.*;

public class test {
    private final static String SQLURL = new String("jdbc:mysql://127.0.0.1/library");
    private final static String SQL_USER = new String("root");
    private final static String SQL_USER_PASSWORD = new String("123456");
    public static void main(String[] args) throws DAOException{

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/library", "root", "123456")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM author");
            System.out.println(resultSet.getMetaData().getColumnCount());


            while(resultSet.next()){
                for (int i=1;i<=resultSet.getMetaData().getColumnCount();i++){
                    System.out.print(resultSet.getString(i)+ ' ');
                }
                //System.out.println(resultSet.getString(++i));
                System.out.println();
            }
            resultSet = statement.executeQuery("SELECT * FROM book");
            while(resultSet.next()){
                for (int i=1;i<=resultSet.getMetaData().getColumnCount();i++){
                    System.out.print(resultSet.getString(i) + " ");
                }
                //System.out.println(resultSet.getString(++i));
                System.out.println();
            }
           resultSet = statement.executeQuery("SELECT * FROM order");
            while(resultSet.next()){
                for (int i=1;i<=resultSet.getMetaData().getColumnCount();i++){
                    System.out.print(resultSet.getString(i) + " ");
                }
                //System.out.println(resultSet.getString(++i));
                System.out.println();
            }
           resultSet = statement.executeQuery("SELECT * FROM user");
            while(resultSet.next()){
                for (int i=1;i<=resultSet.getMetaData().getColumnCount();i++){
                    System.out.print(resultSet.getString(i) + " ");
                }
                //System.out.println(resultSet.getString(++i));
                System.out.println();
            }
            resultSet = statement.executeQuery("SELECT * FROM book_has_order");
            while(resultSet.next()){
                for (int i=1;i<=resultSet.getMetaData().getColumnCount();i++){
                    System.out.print(resultSet.getString(i) + " ");
                }
                //System.out.println(resultSet.getString(++i));
                System.out.println();
            }
        }catch(SQLException e){e.printStackTrace();}

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/library", "root", "123456"/*SQLURL,SQLURL,SQL_USER_PASSWORD*/)){
            Statement statement = connection.createStatement();
            String log = "Valiyha_96";
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user WHERE login ='"+ log+"'");
            while(resultSet.next()){
                for (int i=1;i<=resultSet.getMetaData().getColumnCount();i++){
                    System.out.print(resultSet.getString(i) + " ");
                }
                //System.out.println(resultSet.getString(++i));
                System.out.println();
            }


        } catch (SQLException e) {
            throw new DAOException(e);
        }

    }
}
