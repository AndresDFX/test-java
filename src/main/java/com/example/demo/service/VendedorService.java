package com.example.demo.service;

import com.example.demo.model.Vendedor;
import com.example.demo.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public Vendedor guardarVendedor(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    public Vendedor obtenerPorId(Long id) {
        return vendedorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Vendedor no encontrado"));
    }

    public Vendedor actualizarVendedor(Long id, Vendedor vendedor) {
        Vendedor vendedorExistente = obtenerPorId(id);
        // Copia propiedades de 'vendedor' a 'vendedorExistente'
        return vendedorRepository.save(vendedorExistente);
    }

    public void eliminarVendedor(Long id) {
        vendedorRepository.deleteById(id);
    }

    public List<Vendedor> listarTodos() {
        return vendedorRepository.findAll();
    }
}
