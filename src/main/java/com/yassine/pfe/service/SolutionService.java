package com.yassine.pfe.service;

import com.yassine.pfe.entity.Solution;
import com.yassine.pfe.repository.SolutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SolutionService {

    private final SolutionRepository solutionRepository;

    public List<Solution> getAllSolutions() {
        return solutionRepository.findAll();
    }

    public Optional<Solution> getSolutionById(Long id) {
        return solutionRepository.findById(id);
    }

    public Solution createSolution(Solution solution) {
        return solutionRepository.save(solution);
    }

    public Solution updateSolution(Long id, Solution details) {
        Solution solution = solutionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solution non trouvée : " + id));
        solution.setNom(details.getNom());
        solution.setDescription(details.getDescription());
        return solutionRepository.save(solution);
    }

    public void deleteSolution(Long id) {
        solutionRepository.deleteById(id);
    }
}
