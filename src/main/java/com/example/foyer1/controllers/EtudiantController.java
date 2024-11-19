package com.example.foyer1.controllers;
import com.example.foyer1.entites.etudiant;
import com.example.foyer1.services.IEtudiantService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("api/etudiants")
public class EtudiantController {
    IEtudiantService etudiantService;
    @PostMapping("addetudiant")
    public etudiant ajoutEtudiant(@RequestBody etudiant etudiant) {
        return etudiantService.addEtudiant(etudiant);
    }

    @GetMapping("getetudiant/{idEtudiant}")
    public etudiant getEtudiant(@PathVariable("idEtudiant") long idEtudiant) {
        return etudiantService.getEtudiantById(idEtudiant);
    }

    @DeleteMapping("deleteetudiant")
    public void deleteEtudiant(@RequestBody etudiant etudiant) {
        etudiantService.deleteEtudiant(etudiant);
    }

    @PutMapping("updateetudiant")
    public etudiant modifierEtudiant(@RequestBody etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }

    @GetMapping("getalletudiant")
    public List<etudiant> getAllEtudiant() {
        return etudiantService.getAllEtudiant();
    }
}
