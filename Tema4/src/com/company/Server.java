package com.company;

import java.io.*;
import java.net.*;
import java.rmi.ServerException;

import entities.*;

public class Server {
    private ServerSocket server;
    private Socket s;
    private DataInputStream in;
    private DataOutputStream out;


    Server() {
        try {
            server = new ServerSocket(13000);
            s = server.accept();
            in = new DataInputStream(s.getInputStream());
            out = new DataOutputStream(s.getOutputStream());
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void Close(){
        try{
            out.close();
            in.close();
            s.close();
            server.close();
        }catch(IOException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
    }

    boolean Listen() {
        String command = null;
        try {
            command = in.readUTF();
            switch (command) {
                case "stop": {
                    return false;
                }
                case "login": {
                    String[] credentials = new String[2];
                    credentials[0] = in.readUTF();
                    credentials[1] = in.readUTF();

                    LoginDaoImpl loginDI = new LoginDaoImpl();
                    UserDaoImpl userDI = new UserDaoImpl();

                    Login login = loginDI.SelectLoginById(credentials[0]);
                    if (login.getPassword().equals(credentials[1]))
                        System.out.println(login.toString() + "\n");
                    else {
                        System.out.println("Wrong password!");
                        return false;
                    }
                    User loggedUser = userDI.SelectById(Integer.parseInt(login.getUsername()));
                    System.out.println(loggedUser.toString() + "\n");

                    String role = login.getRole();
                    if(role.equals("admin")) sendResponse(1);
                    else sendResponse(0);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void sendResponse(int resp){
        try{
            out.writeInt(resp);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        while(server.Listen());
        server.Close();
    }

}


