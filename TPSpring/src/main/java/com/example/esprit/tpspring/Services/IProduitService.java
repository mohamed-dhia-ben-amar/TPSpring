package com.example.esprit.tpspring.Services;

import com.example.esprit.tpspring.Entities.Produit;

import java.util.Date;
import java.util.List;

public interface IProduitService {
    List<Produit> retrieveAllProduits();
    Produit addProduit(Produit p, Long idRayon, Long idStock);
    Produit retrieveProduit(Long id);
    void assignProduitToStock(Long idProduit, Long idStock);
    float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate);
}
