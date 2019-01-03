package com.company;

import javafx.application.Application;
import entities.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.Iterator;
import java.util.List;

import static javafx.application.Application.launch;

public class UserWindow extends Application{
    private Stage window;
    private TableView<Product> table;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage)throws Exception{

        window = primaryStage;
        window.setTitle("UserWindow");

        ObservableList<Product> products = FXCollections.observableArrayList();

        ProductDaoImpl pdi = new ProductDaoImpl();
        List<Product> aux = pdi.SelectAllProducts();
        products.addAll(aux);

        TableColumn<Product, String> titluColumn = new TableColumn<>("Titlu");
        titluColumn.setMinWidth(150);
        titluColumn.setCellValueFactory(new PropertyValueFactory<>("titlu"));

        TableColumn<Product, String> descriereColumn = new TableColumn<>("Descriere");
        descriereColumn.setMinWidth(300);
        descriereColumn.setCellValueFactory(new PropertyValueFactory<>("descriere"));

        TableColumn<Product, String> brandColumn = new TableColumn<>("Brand");
        brandColumn.setMinWidth(150);
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));

        TableColumn<Product, String> categorieColumn = new TableColumn<>("Categorie");
        categorieColumn.setMinWidth(150);
        categorieColumn.setCellValueFactory(new PropertyValueFactory<>("categorie"));

        TableColumn<Product, Float> pretColumn = new TableColumn<>("Pret");
        pretColumn.setMinWidth(150);
        pretColumn.setCellValueFactory(new PropertyValueFactory<>("pret"));

        table = new TableView<>();
        table.setItems(products);
        table.getColumns().addAll(titluColumn, descriereColumn, brandColumn, categorieColumn, pretColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);

        Scene scene = new Scene(vBox,900,300);
        window.setScene(scene);
        window.show();

    }

}