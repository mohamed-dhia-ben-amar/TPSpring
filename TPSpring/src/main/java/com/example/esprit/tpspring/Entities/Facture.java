package com.example.esprit.tpspring.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFacture;
    private float montantRemise;
    private float montantFacture;
    @Temporal(TemporalType.DATE)
    private Date dateFacture;
    private boolean active;

    @OneToMany(mappedBy = "facture")
    private List<DetailFacture> detailFactures;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Client client;
}
