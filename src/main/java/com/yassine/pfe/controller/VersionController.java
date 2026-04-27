package com.yassine.pfe.controller;
import com.yassine.pfe.entity.Versions;
import com.yassine.pfe.service.VersionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/versions")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class VersionController {

    private final VersionService versionService;

    @GetMapping
    public List<Versions> getAll() { return versionService.getAllVersions(); }

    @GetMapping("/{id}")
    public ResponseEntity<Versions> getById(@PathVariable Long id) {
        return versionService.getVersionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Versions create(@RequestBody Versions version) {
        return versionService.createVersion(version);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Versions> update(@PathVariable Long id,
                                           @RequestBody Versions version) {
        return ResponseEntity.ok(versionService.updateVersion(id, version));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        versionService.deleteVersion(id);
        return ResponseEntity.noContent().build();
    }
}