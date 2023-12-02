package com.example;

import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ProductAdditionUI extends Application {

    private Magasin magasin; // Référence au magasin

    // Constructeur par défaut
    public ProductAdditionUI() {
        // Initialiser le magasin
        this.magasin = new Magasin(null, null);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ajout de Produit");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        // Numéro de produit
        Label numLabel = new Label("Numero de Produit:");
        TextField numField = new TextField();
        grid.add(numLabel, 0, 0);
        grid.add(numField, 1, 0);
        
        // Description
        Label descLabel = new Label("Description:");
        TextField descField = new TextField();
        grid.add(descLabel, 0, 1);
        grid.add(descField, 1, 1);

        // Quantité en stock
        Label quantiteLabel = new Label("Quantite en Stock:");
        TextField quantiteField = new TextField();
        grid.add(quantiteLabel, 0, 2);
        grid.add(quantiteField, 1, 2);

        // Prix
        Label prixLabel = new Label("Prix:");
        TextField prixField = new TextField();
        grid.add(prixLabel, 0, 3);
        grid.add(prixField, 1, 3);

        // Nom
        Label nomLabel = new Label("Nom:");
        TextField nomField = new TextField();
        grid.add(nomLabel, 0, 4);
        grid.add(nomField, 1, 4);

        // Réservations
        Label reservationsLabel = new Label("Reservations:");
        TextField reservationsField = new TextField();
        grid.add(reservationsLabel, 0, 5);
        grid.add(reservationsField, 1, 5);

        // ... (d'autres champs)

        // Bouton pour ajouter le produit
        Button addButton = new Button("Ajouter Produit");

        addButton.setOnAction(e -> {
            // Récupérer les valeurs des champs et effectuer la validation
           
            try {
                int num = Integer.parseInt(numField.getText().trim());
                String description = descField.getText().trim();
                int quantiteEnStock = Integer.parseInt(quantiteField.getText().trim());
                double prix = Double.parseDouble(prixField.getText().trim());
                String nom = nomField.getText().trim();
                int reservations = Integer.parseInt(reservationsField.getText().trim());

                // Créer un nouveau produit
                Produit produit = new Produit();
                produit.setNumProd(num);
                produit.setDescription(description);
                produit.setquantiteEnStockProd(quantiteEnStock);
                produit.setprixProd(prix);
                produit.setNomProd(nom);
                produit.setReservations(reservations);



                // Ajouter le produit au magasin
                boolean ajoutReussi = magasin.addProduit(produit);

                // Afficher un message de réussite ou d'échec
                if (ajoutReussi) {
                    afficherMessageSucces("Produit ajoute avec succès!");
                    List<Produit> produits = magasin.getProduits();
                    System.out.println("Liste des produits apres l'ajout : " + produits);
                } else {
                    afficherMessageEchec("Echec de l'ajout du produit. Veuillez verifier les valeurs saisies.");
                }
            } catch (NumberFormatException ex) {
                afficherMessageEchec("Veuillez entrer des valeurs numeriques valides pour les champs num, quantite en stock et réservations.");
            }
        });

        grid.add(addButton, 0, 6, 2, 1);

        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void afficherMessageSucces(String message) {
        afficherMessage("Succes", message);
    }

    private void afficherMessageEchec(String message) {
        afficherMessage("echec", message);
    }

    private void afficherMessage(String titre, String contenu) {
        Stage stage = new Stage();
        stage.setTitle(titre);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        Label label = new Label(contenu);
        grid.add(label, 0, 0);

        Scene scene = new Scene(grid, 300, 100);
        stage.setScene(scene);
        stage.show();
    }
}



 




        
