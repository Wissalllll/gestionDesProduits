package com.votre.nom;


import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.*;

    public class ProduitServiceTest {

        @Test
        public void testAjouterProduit() {
            ProduitService produitService = new ProduitService();
            Produit nouveauProduit = new Produit(1L, "Ordinateur", 999.99, 5);
            
            ProduitService produitService2 = new ProduitService();
            Produit nouveauProduit2 = new Produit(2L, "Ordinateur2", 100.89, 4);


            produitService.ajouterProduit(nouveauProduit);
            produitService2.ajouterProduit(nouveauProduit2);
            assertTrue(produitService.produitExiste(nouveauProduit.getId()));
            assertTrue(produitService2.produitExiste(nouveauProduit2.getId()));
        }

        @Test
        public void testChercherProduitParId() {
            ProduitService produitService = new ProduitService();
            Produit produitExist = new Produit(1L, "Livre", 19.99, 10);
            produitService.ajouterProduit(produitExist);
            
            ProduitService produitService2 = new ProduitService();
            Produit produitExist2 = new Produit(2L, "Cahier", 20.88, 18);
            produitService2.ajouterProduit(produitExist2);

            Produit produitTrouve2 = produitService2.chercherProduitParId(2L);
            assertNotNull(produitTrouve2);
            
            Produit produitTrouve = produitService.chercherProduitParId(1L);
            assertNotNull(produitTrouve);
        }

        @Test
        public void testMettreAJourProduit() {
            ProduitService produitService = new ProduitService();
            Produit produitExist = new Produit(1L, "Téléphone", 499.99, 3);
            produitService.ajouterProduit(produitExist);

            Produit produitMaj = new Produit(1L, "Nouveau Téléphone", 599.99, 5);
            produitService.mettreAJourProduit(produitMaj);
            Produit produitApresMaj = produitService.chercherProduitParId(1L);
            assertEquals("Nouveau Téléphone", produitApresMaj.getNom());
        }

        @Test
        public void testSupprimerProduit() {
            ProduitService produitService = new ProduitService();
            Produit produitExist = new Produit(1L, "Montre", 79.99, 15);
            produitService.ajouterProduit(produitExist);
            
            ProduitService produitService2 = new ProduitService();
            Produit produitExist2 = new Produit(2L, "Bracelet", 80.66, 18);
            produitService.ajouterProduit(produitExist2);
            
            produitService.supprimerProduit(1L);
            assertFalse(produitService.produitExiste(1L));

        }

 

    }
