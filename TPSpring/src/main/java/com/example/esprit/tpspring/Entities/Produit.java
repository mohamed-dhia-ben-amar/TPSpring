package com.example.esprit.tpspring.Entities;


import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduit;
    private String codeProduit;
    private String libelleProduit;
    private float prixUnitaire;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Rayon rayon;

    @OneToMany(mappedBy = "produit")
    private List<DetailFacture> detailFactures;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Stock stock;

    @OneToOne
    private DetailProduit detailProduit;

    @ManyToMany(cascade=CascadeType.ALL)
    Set<Fournisseur> fournisseurs;
}
