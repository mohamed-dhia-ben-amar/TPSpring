package com.example.esprit.tpspring.Controllers;

import com.example.esprit.tpspring.Entities.Facture;
import com.example.esprit.tpspring.Repositories.FactureRepository;
import com.example.esprit.tpspring.Services.IFactureService;
import com.example.esprit.tpspring.Services.IFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Facture")
public class FactureRestController {

    @Autowired
    IFactureService iFactureService;

    @Autowired
    FactureRepository factureRepository;

    @GetMapping("/getAll")
    public List<Facture> retrieveAllFactures()
    {
        return iFactureService.retrieveAllFactures();
    }

    @GetMapping("/getOne/{idF}")
    public Facture retrieveFacture(@PathVariable(value = "idF") long idFacture)
    {
        return iFactureService.retrieveFacture(idFacture);
    }

    @DeleteMapping("/delete/{idF}")
    public void removeFacture(@PathVariable(value = "idF") long idFacture)
    {
        iFactureService.cancelFacture(idFacture);
    }

    @GetMapping("/GetFacturesByClient/{idC}")
    List<Facture> getFacturesByClient(@PathVariable(value = "idC") Long idClient){
        return factureRepository.getFactureByClientIdClient(idClient);
    }
}
