package gestion_vehiculos_combustible.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import gestion_vehiculos_combustible.Model.Operaciones;
import gestion_vehiculos_combustible.Repository.OperacionesRepository;

@Service
public class OperacionesService {

    @Autowired
    private OperacionesRepository operacionesRepository;

    public Operaciones guardarOperaciones(@NonNull Operaciones operaciones) {
        return operacionesRepository.save(operaciones);
    }

    public Optional<Operaciones> obtenerOperacionesPorId(@NonNull Long id) {
        return operacionesRepository.findById(id);
    }

    public void eliminarOperaciones(@NonNull Long id) {
        operacionesRepository.deleteById(id);
    }

    public List<Operaciones> listarOperaciones() {
        return operacionesRepository.findAll();
    }

}
