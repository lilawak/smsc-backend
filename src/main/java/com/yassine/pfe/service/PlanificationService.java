package com.yassine.pfe.service;

import com.yassine.pfe.entity.Client;
import com.yassine.pfe.entity.Planification;
import com.yassine.pfe.entity.Versions;
import com.yassine.pfe.repository.ClientRepository;
import com.yassine.pfe.repository.PlanificationRepository;
import com.yassine.pfe.repository.VersionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlanificationService {

    private final PlanificationRepository planificationRepository;
    private final ClientRepository clientRepository;
    private final VersionRepository versionRepository;

    public List<Planification> getAll() {
        return planificationRepository.findAll();
    }

    public Optional<Planification> getById(Long id) {
        return planificationRepository.findById(id);
    }

    public Planification create(Planification p) {
        // Charger le vrai client depuis la BDD
        Client client = clientRepository.findById(p.getClient().getIdClient())
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));

        // Charger la vraie version depuis la BDD
        Versions version = versionRepository.findById(p.getVersion().getIdVersion())
                .orElseThrow(() -> new RuntimeException("Version non trouvée"));

        p.setClient(client);
        p.setVersion(version);

        return planificationRepository.save(p);
    }

    public Planification update(Long id, Planification details) {
        Planification p = planificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Planification non trouvée : " + id));

        // Charger les entités liées
        Client client = clientRepository.findById(details.getClient().getIdClient())
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        Versions version = versionRepository.findById(details.getVersion().getIdVersion())
                .orElseThrow(() -> new RuntimeException("Version non trouvée"));

        p.setTitre(details.getTitre());
        p.setClient(client);
        p.setVersion(version);
        p.setDateCommande(details.getDateCommande());
        p.setDateLivraisonPrevue(details.getDateLivraisonPrevue());
        p.setDateLivraisonReelle(details.getDateLivraisonReelle());

        return planificationRepository.save(p);
    }

    public void delete(Long id) {
        planificationRepository.deleteById(id);
    }
}
