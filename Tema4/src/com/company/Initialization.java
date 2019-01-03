package com.company;

import entities.*;

import java.util.Iterator;
import java.util.List;

public class Initialization {

    public static void main(String[] args) {

        UserDaoImpl userDI = new UserDaoImpl();
        ProductDaoImpl productDI = new ProductDaoImpl();
        LoginDaoImpl loginDI = new LoginDaoImpl();

        /**userDI.CreateUserTable();
         User user1 = new User("Bogdan","Tanase");    --- id = 11
         User user2 = new User("Vlad","Nastasa");     --- id = 12 -> administrator
         User user3 = new User("Maria","Marioara");   --- id = 13
         User user4 = new User("Andrei","Andreescu"); --- id = 14
         userDI.Insert(user1);
         userDI.Insert(user2);
         userDI.Insert(user3);
         userDI.Insert(user4);
         */

        /**loginDI.CreateLoginTable();
        /**Login login1 = new Login("user","11","Tanase");
         Login login2 = new Login("admin","12","Nastasa");
         Login login3 = new Login("user","13","Marioara");
         Login login4 = new Login("user","14","Andreescu");
         loginDI.InsertLogin(login1);
         loginDI.InsertLogin(login2);
         loginDI.InsertLogin(login3);
         loginDI.InsertLogin(login4);*/

        /*List<Login> logins = loginDI.SelectAllLogins();
        Iterator<Login> iterator = logins.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString() + "\n");
        }*/

        /*List<User> users = userDI.SelectAll();
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next().toString() + "\n");
        }*/


            /**productDI.CreateProductTable();
             Product prod1 = new Product("Audi A8 2018","Vrei sa cuceresti si sa rupi soselele? Atunci asta e produsul tau!!!",
             "Audi","masini",149999);
             Product prod2 = new Product("Mercedes AMG GT","Daca credeai ca Audi-ul o sa te ajute, atunci asta o sa-ti intreaca orice asteptare!!!",
             "Mercedes","masini",199999);
             Product prod3 = new Product("Iphone XVII","Suna si pe luna!","Apple","telefoane",359999);
             Product prod4 = new Product("Samsung S17","Suna si pe soare!","Samsung","telefoane",319999);
             Product prod5 = new Product("Gonflabila Kids","Nu este o minge pentru copii, ci o minge in forma de copii!","Noriel","jucarii",50);
             Product prod6 = new Product("Arbaleta","Cea mai buna jucarie pentru copilul vostru! (+3 ani)","Politie Locala","jucarii",30);
             Product prod7 = new Product("Mama Robot","Face ce face o mama cumsecade fara sa tipe ca n-o ajuta nimeni!","Panasonic",
             "electrocasnice", 1499);
             Product prod8 = new Product("Face-teme 2500","Numele spune tot!","Universitatea Bucuresti","electrocasnice",2500);
             Product prod9 = new Product("Creion","Pix cu cerneala neagra naturala de grafit.","Bic","pixuri",1);
             Product prod10 = new Product("Pana Da'Vinci","Daca vrei sa impresionezi ca tu nu scrii cu un pix obisnuit, ci iti place sa dezbraci gainile de pene pentru a scrie," +
             "asta e pentru tine!","Amanetu' Coltu' Strazii","pixuri",10);

             productDI.InsertProduct(prod1); //id = 10
             productDI.InsertProduct(prod2);
             productDI.InsertProduct(prod3);
             productDI.InsertProduct(prod4);
             productDI.InsertProduct(prod5);

             productDI.InsertProduct(prod6);
             productDI.InsertProduct(prod7);
             productDI.InsertProduct(prod8);
             productDI.InsertProduct(prod9);
             productDI.InsertProduct(prod10);*/

        /*List<Product> products = productDI.SelectAllProducts();
        Iterator<Product> iterator = products.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next().toString() + "\n");
        }*/

        }
}
