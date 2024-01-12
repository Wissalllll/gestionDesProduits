package com.votre.nom;

import java.util.ArrayList;
import java.util.List;

public class ProduitService {
    private List<Produit> produits;

    public ProduitService() {
        this.produits = new ArrayList<>();
    }

    public void ajouterProduit(Produit produit) {
        if (produitExiste(produit.getId()) || nomProduitExiste(produit.getNom())) {
            throw new IllegalArgumentException("Un produit avec le même ID ou nom existe déjà.");
        }

        if (produit.getPrix() < 0 || produit.getQuantite() < 0) {
            throw new IllegalArgumentException("Le prix et la quantité des produits doivent être positifs.");
        }

        produits.add(produit);
    }

    public Produit chercherProduitParId(Long id) {
        return produits.stream()
                .filter(produit -> produit.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void mettreAJourProduit(Produit produit) {
        // Vérification de l'existence du produit
        if (!produitExiste(produit.getId())) {
            throw new IllegalArgumentException("Le produit que vous essayez de mettre à jour n'existe pas.");
        }

        // Validation des données (prix et quantité positifs)
        if (produit.getPrix() < 0 || produit.getQuantite() < 0) {
            throw new IllegalArgumentException("Le prix et la quantité des produits doivent être positifs.");
        }

        // Mise à jour du produit
        supprimerProduit(produit.getId());
        ajouterProduit(produit);
    }
    public void supprimerProduit(Long id) {
        // Vérification de l'existence du produit
        if (!produitExiste(id)) {
            throw new IllegalArgumentException("Le produit que vous essayez de supprimer n'existe pas.");
        }

        produits.removeIf(produit -> produit.getId().equals(id));
    }


    private boolean produitExiste(Long id) {
        return produits.stream().anyMatch(produit -> produit.getId().equals(id));
    }

    private boolean nomProduitExiste(String nom) {
        return produits.stream().anyMatch(produit -> produit.getNom().equals(nom));
    }
}
