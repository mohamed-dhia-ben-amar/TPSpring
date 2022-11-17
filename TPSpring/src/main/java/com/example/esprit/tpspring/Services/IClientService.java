package com.example.esprit.tpspring.Services;

import com.example.esprit.tpspring.Entities.CategorieClient;
import com.example.esprit.tpspring.Entities.Client;

import java.util.Date;
import java.util.List;

public interface IClientService {
    List<Client> retrieveAllClients();
    Client addClient(Client c);
    void deleteClient(Long id);
    Client updateClient(Client c);
    Client retrieveClient(Long id);
    public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient,
                                                     Date startDate, Date endDate);
}
