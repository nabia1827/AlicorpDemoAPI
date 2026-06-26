package com.alicorp.demo_alicorp.controller;

import com.alicorp.demo_alicorp.dto.request.RegistrarOperacionRequest;
import com.alicorp.demo_alicorp.dto.response.Response;
import com.alicorp.demo_alicorp.entity.Estado;
import com.alicorp.demo_alicorp.entity.Moneda;
import com.alicorp.demo_alicorp.entity.Operacion;
import com.alicorp.demo_alicorp.service.OperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fx")
public class OperacionController {
    private OperacionService service;


    public OperacionController(OperacionService service) {
        this.service = service;
    }

    @PostMapping("/operaciones")
    public ResponseEntity<Response<Operacion>> registrarOperacion(@RequestBody RegistrarOperacionRequest req) {

        Response<Operacion> response = service.RegistrarOperacion(req);
        if (response.getSuccess()) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(response);
        }else{
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }

    }


    @GetMapping("/operaciones")
    public ResponseEntity<Response<List<Operacion>>> ListarOperaciones(
            @RequestParam Estado estado) {
        Response<List<Operacion>> response = service.ListarOperaciones(estado);

        if (response.getSuccess()) {
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(response);
        }else{
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }
    @PatchMapping("/{id}/estado")
    public ResponseEntity<Response<Boolean>> actualizarEstado(@RequestParam Estado estado, @PathVariable Long id) {
        Response<Boolean> response = service.ActualizarEstado(id,estado);
        if (response.getSuccess()) {
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(response);
        }else{
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }
}
