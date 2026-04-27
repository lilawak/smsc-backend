package com.yassine.pfe.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "planification")
@Data
public class Planification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_planification")
    private Long idPlanification;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_version", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Versions version;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_client", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Client client;

    @Column(name = "titre", nullable = false, length = 200)
    private String titre;

    @Column(name = "date_livraison_prevue")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateLivraisonPrevue;

    @Column(name = "date_livraison_reelle")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateLivraisonReelle;

    @Column(name = "date_commande")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateCommande;

    @Column(name = "date_creation")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateCreation;

    @PrePersist
    public void prePersist() {
        this.dateCreation = LocalDateTime.now();
    }
}