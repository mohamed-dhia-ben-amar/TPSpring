package com.example.esprit.tpspring.Controllers;

import com.example.esprit.tpspring.Entities.Produit;
import com.example.esprit.tpspring.Entities.Produit;
import com.example.esprit.tpspring.Services.IProduitService;
import com.example.esprit.tpspring.Services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produit")
public class ProduitRestController {

    @Autowired
    IProduitService iProduitService;

    @GetMapping("/getAll")
    public List<Produit> retrieveAllProduits()
    {
        return iProduitService.retrieveAllProduits();
    }

    @PostMapping("/add/{idR}/{idS}") //http://localhost:8080/etudiant/add
    public Produit addProduit (@RequestBody Produit c, @PathVariable Long idR, @PathVariable Long idS)
    {
        return  iProduitService.addProduit(c, idR, idS);
    }

    @GetMapping("/getOne/{idC}")
    public Produit retrieveProduit(@PathVariable(value = "idC") long idProduit)
    {
        return iProduitService.retrieveProduit(idProduit);
    }
}
