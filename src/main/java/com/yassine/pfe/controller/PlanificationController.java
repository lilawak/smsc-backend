package com.yassine.pfe.controller;

import com.yassine.pfe.entity.Planification;
import com.yassine.pfe.service.PlanificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/planifications")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PlanificationController {

    private final PlanificationService planificationService;

    @GetMapping
    public List<Planification> getAll(@RequestParam(required = false) Integer days) {
        if(days != null)
        {
            return planificationService.innext(days);
        }
        return planificationService.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Planification> getById(@PathVariable Long id) {
        return planificationService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Planification create(@RequestBody Planification p) {
        return planificationService.create(p);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Planification> update(@PathVariable Long id,
                                                @RequestBody Planification p) {
        return ResponseEntity.ok(planificationService.update(id, p));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        planificationService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
