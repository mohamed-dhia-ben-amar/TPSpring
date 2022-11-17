package com.example.esprit.tpspring.Services;

import com.example.esprit.tpspring.Entities.Fournisseur;
import com.example.esprit.tpspring.Entities.Produit;
import com.example.esprit.tpspring.Repositories.FournisseurRepository;
import com.example.esprit.tpspring.Repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class IFournisseurServiceIMPL implements IFournisseurService{

    @Autowired
    FournisseurRepository fournisseurRepository;
    @Autowired
    ProduitRepository produitRepository;

    @Override
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
        Fournisseur fournisseur = fournisseurRepository.findById(fournisseurId).orElse(null);
        Produit produit = produitRepository.findById(produitId).orElse(null);
        produit.getFournisseurs().add(fournisseur);
        fournisseurRepository.save(fournisseur);
    }
}
