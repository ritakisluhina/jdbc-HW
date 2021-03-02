package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import javax.persistence.Column;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        User userOne = new User("Igor", "Babkin", (byte) 33);
        User userTwo = new User("Rita", "Kiss", (byte) 27);
        User userThree = new User("Bob", "Black", (byte) 48);
        User userFour = new User("Alice", "Wonder", (byte) 21);
        UserServiceImpl myTable = new UserServiceImpl();
        myTable.createUsersTable();
        myTable.saveUser(userOne.getName(), userOne.getLastName(), userOne.getAge());
        System.out.println("User с именем – " + userOne.getName() + " добавлен в базу данных");
        myTable.saveUser(userTwo.getName(), userTwo.getLastName(), userTwo.getAge());
        System.out.println("User с именем – " + userTwo.getName() + " добавлен в базу данных");
        myTable.saveUser(userThree.getName(), userThree.getLastName(), userThree.getAge());
        System.out.println("User с именем – " + userThree.getName() + " добавлен в базу данных");
        myTable.saveUser(userFour.getName(), userFour.getLastName(), userFour.getAge());
        System.out.println("User с именем – " + userFour.getName() + " добавлен в базу данных");
        System.out.println(myTable.getAllUsers());
        myTable.cleanUsersTable();
        myTable.dropUsersTable();
    }
}
