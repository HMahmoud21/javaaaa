 package com.example;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ProductAdditionUI extends Application {
    private Magasin magasin; // Référence au magasin

    public ProductAdditionUI(Magasin magasin) {
        this.magasin = magasin;
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
        Label numLabel = new Label("Numéro de Produit:");
        TextField numField = new TextField();
        grid.add(numLabel, 0, 0);
        grid.add(numField, 1, 0);

        // Description
        Label descLabel = new Label("Description:");
        TextField descField = new TextField();
        grid.add(descLabel, 0, 1);
        grid.add(descField, 1, 1);

        // Quantité en stock
        Label quantiteLabel = new Label("Quantité en Stock:");
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
        Label reservationsLabel = new Label("Réservations:");
        TextField reservationsField = new TextField();
        grid.add(reservationsLabel, 0, 5);
        grid.add(reservationsField, 1, 5);

        // Bouton pour ajouter le produit
        Button addButton = new Button("Ajouter Produit");
        addButton.setOnAction(e -> {
            // Récupérer les valeurs des champs
            int num = Integer.parseInt(numField.getText());
            String description = descField.getText();
            int quantiteEnStock = Integer.parseInt(quantiteField.getText());
            double prix = Double.parseDouble(prixField.getText());
            String nom = nomField.getText();
            int reservations = Integer.parseInt(reservationsField.getText());

            // Créer un nouveau produit
            Produit produit = new Produit();
            produit.setNumProd(num);
            produit.setDescription(description);
            produit.setquantiteEnStockProd(quantiteEnStock);
            produit.setprixProd(prix);
            produit.setNomProd(nom);
            produit.setReservations(reservations);

            // Ajouter le produit au magasin
            magasin.addProduit(produit);

            // Afficher un message (vous pouvez ajouter une boîte de dialogue plus avancée si nécessaire)
            System.out.println("Produit ajouté avec succès!");
        });

        grid.add(addButton, 0, 6, 2, 1);

        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}





































// import javafx.application.Application;
// import javafx.geometry.Insets;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.GridPane;
// import javafx.stage.Stage;

// public class ProductAdditionUI extends Application {

//     @Override
//     public void start(Stage primaryStage) {
//         primaryStage.setTitle("Ajouter un Produit");

//         // Création des composants UI
//         GridPane grid = new GridPane();
//         grid.setHgap(10);
//         grid.setVgap(10);
//         grid.setPadding(new Insets(25, 25, 25, 25));

//         Label labelNum = new Label("Numéro:");
//         TextField textFieldNum = new TextField();

//         Label labelDescription = new Label("Description:");
//         TextField textFieldDescription = new TextField();

//         Label labelQuantite = new Label("Quantité en Stock:");
//         TextField textFieldQuantite = new TextField();

//         Label labelPrix = new Label("Prix:");
//         TextField textFieldPrix = new TextField();

//         Label labelNom = new Label("Nom:");
//         TextField textFieldNom = new TextField();

//         Label labelReservations = new Label("Réservations:");
//         TextField textFieldReservations = new TextField();

//         Button addButton = new Button("Ajouter Produit");

//         // Ajout des composants au grid
//         grid.add(labelNum, 0, 0);
//         grid.add(textFieldNum, 1, 0);

//         grid.add(labelDescription, 0, 1);
//         grid.add(textFieldDescription, 1, 1);

//         grid.add(labelQuantite, 0, 2);
//         grid.add(textFieldQuantite, 1, 2);

//         grid.add(labelPrix, 0, 3);
//         grid.add(textFieldPrix, 1, 3);

//         grid.add(labelNom, 0, 4);
//         grid.add(textFieldNom, 1, 4);

//         grid.add(labelReservations, 0, 5);
//         grid.add(textFieldReservations, 1, 5);

//         grid.add(addButton, 1, 6);

//         // Action du bouton
//         addButton.setOnAction(e -> {
//             // Récupérer les valeurs des champs
//             int num = Integer.parseInt(textFieldNum.getText());
//             String description = textFieldDescription.getText();
//             int quantite = Integer.parseInt(textFieldQuantite.getText());
//             double prix = Double.parseDouble(textFieldPrix.getText());
//             String nom = textFieldNom.getText();
//             int reservations = Integer.parseInt(textFieldReservations.getText());

//             // Vous pouvez maintenant utiliser ces valeurs comme vous le souhaitez
//             // Par exemple, créer un objet Produit et l'ajouter à une liste, etc.
//             // Produit produit = new Produit(num, description, quantite, prix, nom, reservations);
//             // productList.add(produit);
//         });

//         Scene scene = new Scene(grid, 400, 300);
//         primaryStage.setScene(scene);

//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }
