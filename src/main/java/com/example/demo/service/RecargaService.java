package com.example.demo.service;

import com.example.demo.model.Recarga;
import com.example.demo.model.Operador;
import com.example.demo.model.Vendedor;
import com.example.demo.repository.RecargaRepository;
import com.example.demo.repository.OperadorRepository;
import com.example.demo.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
public class RecargaService {

    @Autowired
    private RecargaRepository recargaRepository;

    @Autowired
    private OperadorRepository operadorRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    public Recarga guardarRecarga(Recarga recarga, Long operadorId, Long vendedorId) {
        Operador operador = operadorRepository.findById(operadorId)
                .orElseThrow(() -> new EntityNotFoundException("Operador no encontrado con ID: " + operadorId));
        Vendedor vendedor = vendedorRepository.findById(vendedorId)
                .orElseThrow(() -> new EntityNotFoundException("Vendedor no encontrado con ID: " + vendedorId));

        recarga.setOperador(operador);
        recarga.setVendedor(vendedor);

        return recargaRepository.save(recarga);
    }

    public Recarga obtenerPorId(Long id) {
        return recargaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recarga no encontrada con ID: " + id));
    }

    public Recarga actualizarRecarga(Long id, Recarga recargaActualizada) {
        Recarga recarga = obtenerPorId(id);
        verificarExistenciaOperadorYVendedor(recargaActualizada);
        recarga.setValor(recargaActualizada.getValor());
        recarga.setFecha(recargaActualizada.getFecha());
        recarga.setOperador(recargaActualizada.getOperador());
        recarga.setVendedor(recargaActualizada.getVendedor());
        return recargaRepository.save(recarga);
    }

    public void eliminarRecarga(Long id) {
        recargaRepository.deleteById(id);
    }

    public List<Recarga> listarTodas() {
        return recargaRepository.findAll();
    }

    private void verificarExistenciaOperadorYVendedor(Recarga recarga) {
        operadorRepository.findById(recarga.getOperador().getId())
                .orElseThrow(() -> new EntityNotFoundException("Operador no encontrado con ID: " + recarga.getOperador().getId()));
        vendedorRepository.findById(recarga.getVendedor().getId())
                .orElseThrow(() -> new EntityNotFoundException("Vendedor no encontrado con ID: " + recarga.getVendedor().getId()));
    }
}
