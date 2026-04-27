package com.yassine.pfe.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "versions")
@Data
public class Versions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_version")
    private Long idVersion;

    @ManyToOne
    @JoinColumn(name = "id_solution", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private Solution solution;

    @Column(name = "numero_version", nullable = false, length = 30)
    private String numeroVersion;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "date_release_prevue", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateReleasePrevue;

    @Column(name = "date_release_reelle")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateReleaseReelle;

    @Column(name = "etat", nullable = false, length = 20)
    private String etat = "DEMO";

    @Column(name = "date_creation")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateCreation;

    @PrePersist
    public void prePersist() {
        this.dateCreation = LocalDateTime.now();
    }
}