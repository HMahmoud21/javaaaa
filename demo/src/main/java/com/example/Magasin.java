
package com.example;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Magasin{
    


    private String nom;
    private String adresse;
    private Integer stockMax;
    private List<Produit> produits;

    public Magasin(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        this.stockMax=200;
        this.produits = new ArrayList<>();
    }

    // Getters et setters

    public String getNomMag() {
        return nom;
    }

    public void setNomMag(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Produit> getProduits() {
        return new ArrayList<>(produits);
    }

    // Méthodes d'ajout et de suppression encapsulées

    public boolean addProduit(Produit produit) {
        // Vérifier le stock maximum avant d'ajouter le produit
        if (stockDisponible() + produit.getProdquantiteEnStock() <= stockMax) {
            produits.add(produit);
            return true; // Ajout réussi
        } else {
            return false; // Stock maximum atteint, ajout échoué
        }
    }
    

    public boolean removeProduit(int numProduit) {
        for (Iterator<Produit> iterator = produits.iterator(); iterator.hasNext();) {
            Produit produit = iterator.next();
            if (produit.getNumProd() == numProduit) {
                iterator.remove(); // Supprime le produit de la liste
                return true; // Retourne true si la suppression réussit
            }
        }
        return false; // Retourne false si le produit n'est pas trouvé
    }
    
    

    // Autres méthodes

    public int stockDisponible() {
        int stockTotal = 0;
        for (Produit produit : produits) {
            stockTotal += produit.getProdquantiteEnStock();
        }
        return stockTotal;
    }

    public ArrayList<Produit> getProds() {
        return new ArrayList<>(produits);
    }

    public boolean findProduct(int num) {
        for (Produit produit : produits) {
            if (produit.getNumProd() == num) {
                return true;
            }
        }
        return false;
    }

    public boolean reservation(String nom, int quantite) {
        for (Produit produit : produits) {
            if (produit.getProdnom().equals(nom)) {
                if (quantite < produit.getProdquantiteEnStock()) {
                    produit.setReservations(produit.getReservations() + quantite);
                    produit.setquantiteEnStockProd(produit.getProdquantiteEnStock() - quantite);
                    return true;
                }
            }
        }
        return false;
    }
}

    


