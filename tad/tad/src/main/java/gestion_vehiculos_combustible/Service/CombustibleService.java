package gestion_vehiculos_combustible.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import gestion_vehiculos_combustible.Model.Combustible;
import gestion_vehiculos_combustible.Repository.CombustibleRepository;

@Service
public class CombustibleService {

    @Autowired
    private CombustibleRepository combustibleRepository;

    public Combustible guardarCombustible(@NonNull Combustible combustible) {
        return combustibleRepository.save(combustible);
    }

    public Optional<Combustible> obtenerCombustiblePorId(@NonNull Long id) {
        return combustibleRepository.findById(id);
    }

    public void eliminarCombustible(@NonNull Long id) {
        combustibleRepository.deleteById(id);
    }

    public List<Combustible> listarCombustibles() {
        return combustibleRepository.findAll();
    }

}
