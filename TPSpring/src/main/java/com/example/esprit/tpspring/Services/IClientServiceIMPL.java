package com.example.esprit.tpspring.Services;

import com.example.esprit.tpspring.Entities.CategorieClient;
import com.example.esprit.tpspring.Entities.Client;
import com.example.esprit.tpspring.Entities.Facture;
import com.example.esprit.tpspring.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IClientServiceIMPL implements IClientService{

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> retrieveAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client addClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client updateClient(Client c) {
        return clientRepository.save(c);
    }

    @Override
    public Client retrieveClient(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {
        float somme = 0;
        List<Client> clients = clientRepository.findAll();
        for (Client client : clients) {
            if (client.getCategorieClient() == categorieClient) {
                for (Facture facture : client.getFactures()){
                    if (facture.getDateFacture().compareTo(startDate) > 0 && facture.getDateFacture().compareTo(endDate) < 0) {
                        somme += facture.getMontantFacture() - (facture.getMontantFacture() * facture.getMontantRemise() / 100);
                    }
                }
            }
        }
        return somme;
    }
}
