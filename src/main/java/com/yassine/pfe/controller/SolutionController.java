package com.yassine.pfe.controller;

import com.yassine.pfe.entity.Solution;
import com.yassine.pfe.service.SolutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/solutions")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class SolutionController {

    private final SolutionService solutionService;

    @GetMapping
    public List<Solution> getAll() {
        return solutionService.getAllSolutions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solution> getById(@PathVariable Long id) {
        return solutionService.getSolutionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Solution create(@RequestBody Solution solution) {
        return solutionService.createSolution(solution);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Solution> update(@PathVariable Long id,
                                           @RequestBody Solution solution) {
        return ResponseEntity.ok(solutionService.updateSolution(id, solution));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        solutionService.deleteSolution(id);
        return ResponseEntity.noContent().build();
    }
}