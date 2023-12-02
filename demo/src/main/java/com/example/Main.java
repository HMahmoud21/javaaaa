

package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {


        // Créer un magasin
     Magasin magasin = new Magasin("Mon Magasin", "123 Rue de la Ville");
    public static void main(String[] args) {
        launch(args);
    }
    @Override
public void start(Stage primaryStage) {
    primaryStage.setTitle("Interface Principale");

    VBox vbox = new VBox(10);  // Vertical Box

    Button addButton = new Button("Ajouter Produit");
    addButton.setOnAction(e -> {
        ProductAdditionUI additionUI = new ProductAdditionUI();
        Stage additionStage = new Stage();
        additionUI.start(additionStage);
    });

    Button removeButton = new Button("Supprimer Produit");
    // Lier ce bouton à l'interface de suppression
    removeButton.setOnAction(e -> {
        ProductDeletionUI removeUI = new ProductDeletionUI(magasin);
        Stage removeStage = new Stage();
        removeUI.start(removeStage);
    });

    Button reserveButton = new Button("Réserver Produit");
    ReservationUI reservationUI = new ReservationUI(magasin);
    Stage reservationStage = new Stage();
    reserveButton.setOnAction(e -> reservationUI.start(reservationStage));

    vbox.getChildren().addAll(addButton, removeButton, reserveButton);

    Scene scene = new Scene(vbox, 200, 150);
    primaryStage.setScene(scene);
    primaryStage.show();
}












}