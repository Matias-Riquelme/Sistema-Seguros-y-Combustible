package gestion_vehiculos_combustible.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import gestion_vehiculos_combustible.Model.Conductor;
import gestion_vehiculos_combustible.Repository.ConductorRepository;

@Service
public class ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;

    public Conductor guardarConductor(@NonNull Conductor conductor) {
        return conductorRepository.save(conductor);
    }

    public List<Conductor> listarConductores() {
        return conductorRepository.findAll();
    }

    public Optional<Conductor> obtenerConductorPorId(@NonNull Long id) {
        return conductorRepository.findById(id);
    }

    public void eliminarConductor(@NonNull Long id) {
        conductorRepository.deleteById(id);
    }
}
