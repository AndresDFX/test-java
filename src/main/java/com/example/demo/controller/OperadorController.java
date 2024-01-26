package com.example.demo.controller;

import com.example.demo.model.Operador;
import com.example.demo.service.OperadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List; // Importa List


@RestController
@RequestMapping("/api/operadores")
public class OperadorController {

    @Autowired
    private OperadorService operadorService;

    @PostMapping
    public ResponseEntity<Operador> crearOperador(@RequestBody Operador operador) {
        System.out.println("Operador recibido: " + operador.getNombre()); // Agrega esta línea
        return ResponseEntity.ok(operadorService.guardarOperador(operador));
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Operador> obtenerOperadorPorId(@PathVariable Long id) {
        return ResponseEntity.ok(operadorService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Operador> actualizarOperador(@PathVariable Long id, @RequestBody Operador operador) {
        return ResponseEntity.ok(operadorService.actualizarOperador(id, operador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOperador(@PathVariable Long id) {
        operadorService.eliminarOperador(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Operador>> listarOperadores() {
        return ResponseEntity.ok(operadorService.listarTodos());
    }
}
