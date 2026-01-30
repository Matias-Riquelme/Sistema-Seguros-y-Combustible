package gestion_vehiculos_combustible.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import gestion_vehiculos_combustible.model.Maquina;
import gestion_vehiculos_combustible.repository.MaquinaRepository;

@Service
public class MaquinaService {

    @Autowired
    private MaquinaRepository maquinaRepository;

    public Maquina guardarMaquina(@NonNull Maquina maquina) {
        return maquinaRepository.save(maquina);
    }

    public Optional<Maquina> obtenerMaquinaPorId(@NonNull Long id) {
        return maquinaRepository.findById(id);
    }

    public void eliminarMaquina(@NonNull Long id) {
        maquinaRepository.deleteById(id);
    }

    public List<Maquina> listarMaquinas() {
        return maquinaRepository.findAll();
    }

}
