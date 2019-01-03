package com.company;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import entities.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import static javafx.application.Application.launch;

public class LoginWindow{
    private JButton buttonLogin;
    private JPanel panelMain;
    private JTextField textUsername;
    private JPasswordField textPassword;
    private JPanel panelUsername;
    private JLabel labelUsername;
    private JLabel labelPassword;

    public static void CloseOperation(){
        Client.stopServer();
    }

    public LoginWindow() {
        buttonLogin.addActionListener(e -> {
            if (!textUsername.getText().isEmpty() && !textPassword.getText().isEmpty()) {
                String[] credentials = new String[2];
                credentials[0] = textUsername.getText();
                credentials[1] = textPassword.getText();
                if(credentials!= null)Client.sendLoginData(credentials);
            }
        });
    }

    public static void main (String[]args){
        JFrame frame = new JFrame("LoginWindow");
        frame.sContentPane(new LoginWindow().panelMain);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame,
                        "Are you sure to close this window?", "Really Closing?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    CloseOperation();
                    System.exit(0);
                }
            }
        });
        frame.pack();
        frame.setVisible(true);
    }
}
