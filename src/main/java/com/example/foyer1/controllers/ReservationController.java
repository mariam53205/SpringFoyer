package com.example.foyer1.controllers;

import com.example.foyer1.entites.Reservation;
import com.example.foyer1.services.IReservationService;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("api/reservations")
public class ReservationController {
    IReservationService reservationService;
    @PostMapping("addreservation")
    public Reservation ajoutReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @GetMapping("getreservation/{idReservation}")
    public Reservation getReservation(@PathVariable("idReservation") int idReservation) {
        return reservationService.getReservationById(idReservation);
    }

    @DeleteMapping("deletereservation")
    public void deleteReservation(@RequestBody Reservation reservation) {
        reservationService.deleteReservation(reservation);
    }

    @PutMapping("updatereservation")
    public Reservation modifierReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    @GetMapping("getallreservation")
    public List<Reservation> getAllReservation() {
        return reservationService.getAllReservation();
    }

    @PutMapping("/etudiantToResevation/{idetudiant}/{idReservation}")
    @Operation(summary = "etudiant To Resevation", description = "etudiant To Resevation.")
    public Reservation affecterEtudiantToReservation(@PathVariable("idetudiant") Long idetudiant, @PathVariable("idReservation") long idReservation) {
        return reservationService.affecterEtudiantToReservation(idetudiant,idReservation);
    }

    @PutMapping("desaffecterEtudiantFromReservation/{reservationId}/{etudiantId}")
    public void desaffecterEtudiantFromReservation(@PathVariable ("reservationId") String reservationId, @PathVariable ("etudiantId") Long etudiantId) {
        reservationService.desaffecterEtudiantFromReservation(reservationId , etudiantId);
    }

}
