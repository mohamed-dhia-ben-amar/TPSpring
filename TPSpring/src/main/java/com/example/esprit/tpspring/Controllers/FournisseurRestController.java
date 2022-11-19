package com.example.esprit.tpspring.Controllers;

import com.example.esprit.tpspring.Services.IFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Fournisseur")
public class FournisseurRestController {

    @Autowired
    IFournisseurService iFournisseurService;

    @GetMapping("/AssignFournisseurToProduit/{idF}/{idP}")
    public void assignFournisseurToProduit(@PathVariable(value = "idF") Long fournisseurId, @PathVariable(value = "idP") Long produitId) {
        iFournisseurService.assignFournisseurToProduit(fournisseurId, produitId);
    }

}
