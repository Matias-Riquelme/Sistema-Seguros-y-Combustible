package gestion_vehiculos_combustible.service;

import gestion_vehiculos_combustible.model.Odometro;
import gestion_vehiculos_combustible.repository.OdometroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdometroService {

    @Autowired
    private OdometroRepository odometroRepository;

    public Odometro guardarOdometro(Odometro odometro) {
        return odometroRepository.save(odometro);
    }

    public List<Odometro> listarOdometros() {
        return odometroRepository.findAll();
    }

    public Optional<Odometro> obtenerOdometroPorId(Long id) {
        return odometroRepository.findById(id);
    }

    public void eliminarOdometro(Long id) {
        odometroRepository.deleteById(id);
    }
}
