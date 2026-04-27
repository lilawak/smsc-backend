package com.yassine.pfe.service;

import com.yassine.pfe.entity.Versions;
import com.yassine.pfe.repository.VersionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VersionService {

    private final VersionRepository versionRepository;

    public List<Versions> getAllVersions() {
        return versionRepository.findAll();
    }

    public Optional<Versions> getVersionById(Long id) {
        return versionRepository.findById(id);
    }

    public Versions createVersion(Versions version) {
        return versionRepository.save(version);
    }

    public Versions updateVersion(Long id, Versions details) {
        Versions version = versionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Version non trouvée : " + id));
        version.setNumeroVersion(details.getNumeroVersion());
        version.setDescription(details.getDescription());
        version.setDateReleasePrevue(details.getDateReleasePrevue());
        version.setDateReleaseReelle(details.getDateReleaseReelle());
        version.setEtat(details.getEtat());
        version.setSolution(details.getSolution());
        return versionRepository.save(version);
    }

    public void deleteVersion(Long id) {
        versionRepository.deleteById(id);
    }
}