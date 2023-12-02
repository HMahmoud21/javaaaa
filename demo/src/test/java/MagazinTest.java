import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

import com.example.Magasin;
import com.example.Produit;

public class MagazinTest {

    @Test
    public void testProduitExiste() {
        Magasin magasin = new Magasin("NomMagasin", "AdresseMagasin");
        Produit produit = new Produit();
        produit.setNumProd(1);
        produit.setNomProd("Article 1");
        produit.setquantiteEnStockProd(10);

        magasin.addProduit(produit);

        assertTrue(magasin.findProduct(1)); // Le produit devrait exister dans le magasin
        assertFalse(magasin.findProduct(2)); // Le produit ne devrait pas exister dans le magasin
    }

    @Test
    public void testSupprimerProduit() {
        Magasin magasin = new Magasin("NomMagasin", "AdresseMagasin");
        Produit produit = new Produit();
        produit.setNumProd(1);
        produit.setNomProd("Article 1");
        produit.setquantiteEnStockProd(10);
    
        magasin.addProduit(produit);
    
        assertTrue(magasin.findProduct(1)); // Le produit devrait exister avant la suppression
    
        // Utiliser la méthode removeProduit avec le numéro du produit
        magasin.removeProduit(1);
    
        assertFalse(magasin.findProduct(1)); // Le produit ne devrait plus exister après la suppression
    }
    

    @Test
    public void testReserverProduit() {
        Magasin magasin = new Magasin("NomMagasin", "AdresseMagasin");
        Produit produit = new Produit();
        produit.setNumProd(1);
        produit.setNomProd("Article 1");
        produit.setquantiteEnStockProd(10);

        magasin.addProduit(produit);

        assertFalse(produit.getReservations() > 0); // Le produit ne devrait pas être réservé initialement

        assertTrue(magasin.reservation("Article 1", 5)); // La réservation devrait réussir

        assertTrue(produit.getReservations() > 0); // Le produit devrait maintenant être réservé
    }

    /**
     * 
     */
    // @Test
    // public void testAddProduit() {
    //     Produit produit1 = new Produit();
    //     Magasin magasin = new Magasin("NomMagasin", "AdresseMagasin");
    //     produit1.setNumProd(1);
    //     produit1.setNomProd("Produit 1");
    //     produit1.setquantiteEnStockProd(10);
    //     produit1.setprixProd(29.99);

    //     Produit produit2 = new Produit();
    //     produit2.setNumProd(2);
    //     produit2.setNomProd("Produit 2");
    //     produit2.setquantiteEnStockProd(5);
    //     produit2.setprixProd(19.99);

    //     // Ajout de produits dans le magasin
    //       magasin.addProduit(produit1);
    //       magasin.addProduit(produit2);

    //     // Ajout d'un produit qui dépasse le stock maximum
    //     Produit produit3 = new Produit();
    //     produit3.setNumProd(3);
    //     produit3.setNomProd("Produit 3");
    //     produit3.setquantiteEnStockProd(200); // Stock maximum
    //     produit3.setprixProd(9.99);

    //     assertFalse(magasin.addProduit(produit3)); // Cette opération doit échouer

    //     // Vérification du stock après les ajouts
    //     assertEquals(15, magasin.stockDisponible());
    //     assertEquals(2, magasin.getProduits().size());
    // }


    @Test
public void testAddProduitViaFormulaire() {
    Magasin magasin = new Magasin("NomMagasin", "AdresseMagasin");

    // Simuler des données de formulaire
    int numProduit = 1;
    String nomProduit = "Produit Test";
    int quantiteEnStock = 20;
    double prixProduit = 15.99;

    // Appeler la méthode addProduit avec les données simulées
    Produit produit = new Produit();
    produit.setNumProd(numProduit);
    produit.setNomProd(nomProduit);
    produit.setquantiteEnStockProd(quantiteEnStock);
    produit.setprixProd(prixProduit);

    boolean ajoutReussi = magasin.addProduit(produit);

    assertTrue(ajoutReussi);
    assertTrue(magasin.findProduct(numProduit));
    assertEquals(quantiteEnStock, magasin.stockDisponible());
}

    
}
