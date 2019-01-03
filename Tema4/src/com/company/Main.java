package com.company;

import entities.*;

/**
 * Test DB
 */

public class Main {

    public static void main(String[] args) {

        UserDaoImpl userTable = new UserDaoImpl();

        userTable.CreateUserTable();

        User user = new User("Vlad","Nastasa");

        userTable.Insert(user);

        System.out.println(userTable.SelectById(1).toString());

        userTable.Delete(1);
    }

}
