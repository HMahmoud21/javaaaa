package com.example;

public class Main {
    public static void main(String[] args) {
        // Créer quelques produits
        Produit produit1 = new Produit();
        produit1.setNumProd(1);
        produit1.setNomProd("Produit 1");
        produit1.setquantiteEnStockProd(10);
        produit1.setprixProd(29.99);

        Produit produit2 = new Produit();
        produit2.setNumProd(2);
        produit2.setNomProd("Produit 33");
        produit2.setquantiteEnStockProd(5);
        produit2.setprixProd(19.99);

        // Créer un magasin
        Magasin magasin = new Magasin("Mon Magasin", "123 Rue de la Ville");

        // Ajouter les produits au magasin
        magasin.addProduit(produit1);
        magasin.addProduit(produit2);

        // Afficher les informations du magasin
        System.out.println("Nom du magasin : " + magasin.getNomMag());
        System.out.println("Adresse du magasin : " + magasin.getAdresse());

        // Afficher les produits du magasin
        System.out.println("Liste des produits dans le magasin :");
        for (Produit produit : magasin.getProduits()) {
            System.out.println(produit.toString());
        }

        // Tester la réservation d'un produit
        boolean reservationReussie = magasin.reservation("Produit 1", 3);
        if (reservationReussie) {
            System.out.println("Réservation réussie !");
        } else {
            System.out.println("La réservation a échoué. Stock insuffisant.");
        }

        // Afficher à nouveau les informations des produits après la réservation
        System.out.println("Liste des produits dans le magasin après la réservation :");
        for (Produit produit : magasin.getProduits()) {
            System.out.println(produit.toString());
        }

        // Lancer l'interface utilisateur pour ajouter un produit
        // ProductAdditionUI.launch(ProductAdditionUI.class, args);
        // Lancer l'interface utilisateur pour supprimer un produit
        ProductDeletionUI productDeletionUI = new ProductDeletionUI(magasin);
        productDeletionUI.launch(args);

    }
    }

