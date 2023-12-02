
package com.example;


public class Produit {
int num;
String description;
int quantiteEnStock;
 double prix;
 String nom;
 int reservations;

public void setDescription(String description) {
    this.description = description;
}
public int getNumProd() {
	return num;
}
public void setNumProd(int id) {
	this.num = id;
}
public String getProdnom() {
	return nom;
}
public void setNomProd(String nom) {
	this.nom = nom;
}
public int getProdquantiteEnStock() {
	return quantiteEnStock-this.reservations;
}
public void setquantiteEnStockProd(int p) {
	this.quantiteEnStock = p+ this.quantiteEnStock ;
}
public double getProdprix() {
	return prix;
}
public void setprixProd(double p) {
	this.prix = p;
}
public int getReservations() {  return reservations; }

public void setReservations(int reservations) {
    if(reservations <= quantiteEnStock && reservations >= 0){
        this.reservations = reservations;
    }
}

@Override
public String toString() {
    return "Client{" +
            "num=" + num +
            ", nom='" + nom + '\'' +
            ", prix='" + prix + '\'' +
            ", quantiteEnStock='" + quantiteEnStock + '\''+ 
            '}';
}
}


