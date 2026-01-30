package gestion_vehiculos_combustible.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion_vehiculos_combustible.Model.Base;
import gestion_vehiculos_combustible.Repository.BaseRepository;

@Service
public class BaseService {

    @Autowired
    private BaseRepository baseRepository;

    public Base guardarBase(@NonNull Base base) {
        return baseRepository.save(base);
    }

    public Optional<Base> obtenerBasePorId(@NonNull Long id) {
        return baseRepository.findById(id);
    }

    public void eliminarBase(@NonNull Long id) {
        baseRepository.deleteById(id);
    }

    public List<Base> listarBases() {
        return baseRepository.findAll();
    }

}
