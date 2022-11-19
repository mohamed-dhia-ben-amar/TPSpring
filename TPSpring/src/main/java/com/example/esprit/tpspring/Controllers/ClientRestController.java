package com.example.esprit.tpspring.Controllers;

import com.example.esprit.tpspring.Entities.CategorieClient;
import com.example.esprit.tpspring.Entities.Client;
import com.example.esprit.tpspring.Services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("client")
public class ClientRestController {

    @Autowired
    IClientService iClientService;

    @GetMapping("/getAll")
    public List<Client> retrieveAllClients()
    {
        return iClientService.retrieveAllClients();
    }

    @PostMapping("/add") //http://localhost:8080/etudiant/add
    public Client addClient (@RequestBody Client c)
    {
        return  iClientService.addClient(c);
    }

    @PostMapping("/update")
    public Client updateClient(@RequestBody Client c)
    {
        return  iClientService.updateClient(c);
    }

    @GetMapping("/getOne/{idC}")
    public Client retrieveClient(@PathVariable(value = "idC") long idClient)
    {
        return iClientService.retrieveClient(idClient);
    }

    @DeleteMapping("/delete/{idC}")
    public void removeClient(@PathVariable(value = "idC") long idClient)
    {
        iClientService.deleteClient(idClient);
    }

    @GetMapping("/GetChiffreAffaireParCategorieClient/{categorieClient}/{startDate}/{endDate}")
    public float getChiffreAffaireParCategorieClient(@PathVariable(value = "categorieClient") CategorieClient categorieClient, @PathVariable(value = "startDate") Date startDate, @PathVariable(value = "endDate") Date endDate) {
        return iClientService.getChiffreAffaireParCategorieClient(categorieClient, startDate, endDate);
    }

}
