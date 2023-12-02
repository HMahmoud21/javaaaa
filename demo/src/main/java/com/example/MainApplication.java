package com.example;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
       

        Magasin magasin;
        // Exemple de lancement de l'interface d'ajout de produit
        final ProductAdditionUI productAdditionUI = new ProductAdditionUI(magasin);
        productAdditionUI.launch(ProductAdditionUI.class);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
