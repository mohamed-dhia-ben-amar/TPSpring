package com.example.esprit.tpspring.Services;

import com.example.esprit.tpspring.Entities.*;
import com.example.esprit.tpspring.Repositories.ProduitRepository;
import com.example.esprit.tpspring.Repositories.RayonRepository;
import com.example.esprit.tpspring.Repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IProduitServiceIMPL implements IProduitService{

    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    RayonRepository rayonRepository;
    @Autowired
    StockRepository stockRepository;

    @Override
    public List<Produit> retrieveAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Produit addProduit(Produit p, Long idRayon, Long idStock) {
        Rayon rayon = rayonRepository.findById(idRayon).orElse(null);
        Stock stock = stockRepository.findById(idStock).orElse(null);
        if (rayon != null && stock != null) {
            p.setRayon(rayon);
            p.setStock(stock);
        }
        return produitRepository.save(p);
    }

    @Override
    public Produit retrieveProduit(Long id) {
        return produitRepository.findById(id).orElse(null);
    }

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Produit produit = produitRepository.findById(idProduit).orElse(null);
        Stock stock = stockRepository.findById(idStock).orElse(null);
        if (produit != null && stock != null) {
            produit.setStock(stock);
            produitRepository.save(produit);
        }
    }

    @Override
    public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
        float revenue = 0;
        Produit produit = produitRepository.findById(idProduit).orElse(null);
        if (produit != null) {
            for (DetailFacture detailFacture : produit.getDetailFactures()) {
                if (detailFacture.getFacture().getDateFacture().compareTo(startDate) > 0 && detailFacture.getFacture().getDateFacture().compareTo(endDate) < 0) {
                    revenue += detailFacture.getQte() * detailFacture.getPrixTotal();
                }
            }
        }
        return revenue;
    }
}
