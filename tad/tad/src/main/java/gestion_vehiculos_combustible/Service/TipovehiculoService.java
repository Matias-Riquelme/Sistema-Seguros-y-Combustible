package gestion_vehiculos_combustible.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion_vehiculos_combustible.model.Tipovehiculo;
import gestion_vehiculos_combustible.repository.TipovehiculoRepository;

@Service
public class TipovehiculoService {

    @Autowired
    private TipovehiculoRepository tipovehiculoRepository;

    public Tipovehiculo guardarTipovehiculo(Tipovehiculo tipovehiculo) {
        return tipovehiculoRepository.save(tipovehiculo);
    }

    public List<Tipovehiculo> listarTipovehiculos() {
        return tipovehiculoRepository.findAll();
    }

    public Optional<Tipovehiculo> obtenerTipovehiculoPorId(Long id) {
        return tipovehiculoRepository.findById(id);
    }

    public void eliminarTipovehiculo(Long id) {
        tipovehiculoRepository.deleteById(id);
    }
}
