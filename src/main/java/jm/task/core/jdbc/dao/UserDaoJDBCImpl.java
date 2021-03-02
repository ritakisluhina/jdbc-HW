package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private Connection connection;

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        String sql = "create table if not exists Users ( "
                + "id INTEGER not NULL AUTO_INCREMENT PRIMARY KEY , "
                + "name VARCHAR(50), "
                + "lastname VARCHAR(50), "
                + "age INT ) ";
        Statement statement = null;
        try {
            connection = Util.getConnection();
            statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String sql = "drop table if exists Users";
        Statement statement = null;
        try {
            connection = Util.getConnection();
            statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "insert into Users (name, lastname, age)"
                + "values ('" + name + "', '" + lastName + "', '" + age + "'); ";
        Statement statement = null;
        try {
            connection = Util.getConnection();
            statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String sql = "delete from users where id =" + id + ";";
        Statement statement = null;
        try {
            connection = Util.getConnection();
            statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> usersFromTable = new ArrayList<>();

        String sql = "select * from users;";
        Statement statement = null;
        try {
            connection = Util.getConnection();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                usersFromTable.add(new User(rs.getLong(1), rs.getString(2)
                        , rs.getString(3)
                        , (byte) rs.getInt(4)));
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return usersFromTable;
    }

    public void cleanUsersTable() {
        String sql = "TRUNCATE users;";
        Statement statement = null;
        try {
            Connection connection = Util.getConnection();
            statement = connection.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
