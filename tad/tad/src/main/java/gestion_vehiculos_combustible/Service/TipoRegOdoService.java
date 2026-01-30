package gestion_vehiculos_combustible.service;

import gestion_vehiculos_combustible.model.TipoRegOdo;
import gestion_vehiculos_combustible.repository.TipoRegOdoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoRegOdoService {

    @Autowired
    private TipoRegOdoRepository tipoRegOdoRepository;

    public TipoRegOdo guardarTipoRegOdo(TipoRegOdo tipoRegOdo) {
        return tipoRegOdoRepository.save(tipoRegOdo);
    }

    public List<TipoRegOdo> listarTipoRegOdo() {
        return tipoRegOdoRepository.findAll();
    }

    public Optional<TipoRegOdo> obtenerTipoRegOdoPorId(Long id) {
        return tipoRegOdoRepository.findById(id);
    }

    public void eliminarTipoRegOdo(Long id) {
        tipoRegOdoRepository.deleteById(id);
    }
}
