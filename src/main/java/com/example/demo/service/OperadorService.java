package com.example.demo.service;

import com.example.demo.model.Operador;
import com.example.demo.repository.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List; // Importa List
import javax.persistence.EntityNotFoundException; // Importa EntityNotFoundException



@Service
public class OperadorService {

    @Autowired
    private OperadorRepository operadorRepository;

    public Operador guardarOperador(Operador operador) {
        return operadorRepository.save(operador);
    }

    public Operador obtenerPorId(Long id) {
        return operadorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Operador no encontrado"));
    }

    public Operador actualizarOperador(Long id, Operador operador) {
        Operador operadorExistente = obtenerPorId(id);
        // Copia propiedades de 'operador' a 'operadorExistente'
        return operadorRepository.save(operadorExistente);
    }

    public void eliminarOperador(Long id) {
        operadorRepository.deleteById(id);
    }

    public List<Operador> listarTodos() {
        return operadorRepository.findAll();
    }
}
