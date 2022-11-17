package com.example.esprit.tpspring.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetailProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDetailProduit;
    @Temporal(TemporalType.DATE)
    private Date dateCration;
    @Temporal(TemporalType.DATE)
    private Date dateDerniereModification;
    private CategorieProduit categorieProduit;

    @OneToOne (mappedBy = "detailProduit")
    private Produit produit;
}
