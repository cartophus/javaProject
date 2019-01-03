package com.company;

import java.net.*;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import entities.*;
import javafx.application.Application;
import javafx.stage.Stage;

import javax.xml.crypto.Data;

public class Client {

    private static Socket s;
    private static DataOutputStream out;
    private static DataInputStream in;

    public static void initClient(){
        try {
            s = new Socket("localhost", 13000);
            System.out.println("Connected_to_server");
            out = new DataOutputStream(s.getOutputStream());
            in = new DataInputStream(s.getInputStream());
        }catch(Exception e){
            System.out.println("Client error");
        }
    }

    public static void stopServer(){
        if(s==null) initClient();
        try {
            out.writeUTF("stop");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendLoginData(String[] credentials){
        if(s==null) initClient();
        try{
            out.writeUTF("login");
            out.writeUTF(credentials[0]);
            out.writeUTF(credentials[1]);
            int response = in.readInt();
            if(response == 1){
                //new Thread(() -> Application.launch(AdminWindow.class)).start();
            }else{
                new Thread(() -> Application.launch(UserWindow.class)).start();
            }

        }catch(IOException e){
            e.printStackTrace();
        }catch(java.lang.Exception e){
            e.printStackTrace();
        }
    }
}
