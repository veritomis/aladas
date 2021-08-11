package ar.com.ada.api.aladas.controllers;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.aladas.entities.Reserva;
import ar.com.ada.api.aladas.models.request.InfoReservaNueva;
import ar.com.ada.api.aladas.models.response.GenericResponse;
import ar.com.ada.api.aladas.services.ReservaService;

@RestController
public class ReservaController {
    @Autowired
    ReservaService service;

    @PostMapping("/api/reservas")
    public ResponseEntity<GenericResponse> generarReserva(@RequestBody InfoReservaNueva infoReserva) {
        GenericResponse rta = new GenericResponse();

        Integer numeroReserva = service.generarReserva(infoReserva.vueloId);

        rta.id = numeroReserva;
        rta.isOk = true;
        rta.message = "Reserva creada";

        return ResponseEntity.ok(rta);

    }

}
