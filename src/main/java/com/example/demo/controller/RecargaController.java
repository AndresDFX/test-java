package com.example.demo.controller;

import com.example.demo.model.Recarga;
import com.example.demo.service.RecargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recargas")
public class RecargaController {

    @Autowired
    private RecargaService recargaService;

    @PostMapping
    public ResponseEntity<Recarga> crearRecarga(@RequestBody Recarga recarga, 
                                                @RequestParam Long operadorId, 
                                                @RequestParam Long vendedorId) {
        return ResponseEntity.ok(recargaService.guardarRecarga(recarga, operadorId, vendedorId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recarga> obtenerRecargaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(recargaService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recarga> actualizarRecarga(@PathVariable Long id, @RequestBody Recarga recarga) {
        return ResponseEntity.ok(recargaService.actualizarRecarga(id, recarga));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRecarga(@PathVariable Long id) {
        recargaService.eliminarRecarga(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Recarga>> listarRecargas() {
        return ResponseEntity.ok(recargaService.listarTodas());
    }
}
