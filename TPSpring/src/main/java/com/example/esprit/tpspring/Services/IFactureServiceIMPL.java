package com.example.esprit.tpspring.Services;

import com.example.esprit.tpspring.Entities.Facture;
import com.example.esprit.tpspring.Repositories.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IFactureServiceIMPL implements IFactureService{

    @Autowired
    FactureRepository factureRepository;

    @Override
    public List<Facture> retrieveAllFactures() {
        return factureRepository.findAll();
    }

    @Override
    public void cancelFacture(Long id) {
        if (factureRepository.findById(id).get().isActive() == false) {
            factureRepository.deleteById(id);
        }
    }

    @Override
    public Facture retrieveFacture(Long id) {
        return factureRepository.findById(id).orElse(null);
    }
}
