package com.example.esprit.tpspring.Services;

import com.example.esprit.tpspring.Entities.Facture;

import java.util.List;

public interface IFactureService {
    List<Facture> retrieveAllFactures();
    void cancelFacture(Long id);
    Facture retrieveFacture(Long id);
}
