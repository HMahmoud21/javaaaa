package com.example;




import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProductDeletionUI extends Application {

    private Magasin magasin; // Référence au magasin

    public ProductDeletionUI(Magasin magasin) {
        this.magasin = magasin;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Suppression de Produit");

        // Créer les éléments de l'interface utilisateur
        Label label = new Label("Numéro de produit à supprimer:");
        TextField numProduitField = new TextField();
        Button deleteButton = new Button("Supprimer");

        // Définir l'action du bouton
        deleteButton.setOnAction(e -> {
            // Récupérer le numéro de produit saisi
            try {
                int numProduit = Integer.parseInt(numProduitField.getText());

                // Appeler la méthode removeProduit du magasin
                boolean suppressionReussie = magasin.removeProduit(numProduit);

                if (suppressionReussie) {
                    System.out.println("Produit supprimé avec succès !");
                } else {
                    System.out.println("La suppression du produit a échoué. Numéro de produit introuvable.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Veuillez saisir un numéro de produit valide.");
            }
        });

        // Créer la mise en page de l'interface utilisateur
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(label, numProduitField, deleteButton);

        // Afficher l'interface utilisateur
        Scene scene = new Scene(layout, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // // Méthode main pour lancer l'interface utilisateur
    // public static void main(String[] args) {
    //     // Créer un magasin
    //     Magasin magasin = new Magasin("NomMagasin", "AdresseMagasin");

    //     // Lancer l'interface utilisateur pour supprimer un produit
    //     ProductDeletionUI.launch(args);
    // }
}


















// import javafx.application.Application;
// import javafx.geometry.Insets;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.control.TextField;
// import javafx.scene.layout.HBox;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;

// public class ProductDeletionUI extends Application {

//     private Magasin magasin; // Ajout de la variable d'instance

//     // Constructeur prenant une instance de Magasin en paramètre
//     public ProductDeletionUI(Magasin magasin) {
//         this.magasin = magasin;
//     }

//     @Override
//     public void start(Stage primaryStage) {
//         primaryStage.setTitle("Supprimer un Produit");

//         // Création des éléments de l'interface
//         Label labelNumProduit = new Label("Numéro de Produit:");
//         TextField textFieldNumProduit = new TextField();

//         Button btnConfirmer = new Button("Confirmer");
//         Button btnAnnuler = new Button("Annuler");

//         // Gestionnaire d'événements pour le bouton de confirmation
//         btnConfirmer.setOnAction(event -> {
//             // Récupérer le numéro du produit saisi
//             String numProduitText = textFieldNumProduit.getText();

//             // Convertir le numéro en entier (assurez-vous de gérer les erreurs si la conversion échoue)
//             int numProduit = Integer.parseInt(numProduitText);

//             // Appeler la méthode de suppression du produit avec le numéro
//             // (vous devez implémenter cette méthode dans votre classe Magasin)
//             boolean suppressionReussie = magasin.removeProduit(numProduit);

//             if (suppressionReussie) {
//                 System.out.println("Produit supprimé avec succès.");
//             } else {
//                 System.out.println("Échec de la suppression du produit. Vérifiez le numéro du produit.");
//             }
//         });

//         // Gestionnaire d'événements pour le bouton d'annulation
//         btnAnnuler.setOnAction(event -> {
//             // Fermer la fenêtre sans effectuer de suppression
//             primaryStage.close();
//         });

//         // Disposition des éléments dans la fenêtre
//         VBox vbox = new VBox(10);
//         vbox.setPadding(new Insets(10));
//         vbox.getChildren().addAll(labelNumProduit, textFieldNumProduit, new HBox(10, btnConfirmer, btnAnnuler));

//         Scene scene = new Scene(vbox, 300, 150);
//         primaryStage.setScene(scene);

//         primaryStage.show();
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }
