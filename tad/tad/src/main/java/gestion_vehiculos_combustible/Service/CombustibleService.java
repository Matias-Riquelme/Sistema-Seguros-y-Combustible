package gestion_vehiculos_combustible.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import gestion_vehiculos_combustible.model.Combustible;
import gestion_vehiculos_combustible.model.Vehiculo;
import gestion_vehiculos_combustible.repository.CombustibleRepository;
import gestion_vehiculos_combustible.repository.VehiculoRepository;

@Service
public class CombustibleService {

    @Autowired
    private CombustibleRepository combustibleRepository;

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public Combustible guardarCombustible(@NonNull Combustible combustible) {
        if (combustible.getVehiculo() != null) {
            Long vehiculoId = combustible.getVehiculo().getId();
            if (vehiculoId != null) {

                // 1. Vincular vehículo
                Vehiculo vehiculo = vehiculoRepository.findById(vehiculoId)
                        .orElseThrow(
                                () -> new IllegalArgumentException("Vehículo no encontrado con ID: " + vehiculoId));
                combustible.setVehiculo(vehiculo);

                // 2. Lógica para "Uso Propio" (Máquina) vs Carga Externa
                if (combustible.isUsoPropio()) {
                    // Validar que se ingresen los datos de la máquina
                    if (combustible.getSInicial() <= 0 || combustible.getSFinal() <= 0) {
                        throw new IllegalArgumentException(
                                "Si es uso propio, debe ingresar SInicial y SFinal de la máquina.");
                    }
                    // Si es uso propio, los consumos (litros) se sacan de los contadores de la
                    // máquina (SInicial/SFinal)
                    if (combustible.getSFinal() < combustible.getSInicial()) {
                        throw new IllegalArgumentException("El SFinal de la máquina no puede ser menor al SInicial");
                    }
                    combustible.setConsumos(combustible.getSFinal() - combustible.getSInicial());
                }

                // 3. Lógica de Kilometraje del Vehículo (KMINICIAL, KMFINAL del Excel)
                // Automatizar KMinicial del registro si viene en 0, usando el estado actual del
                // vehículo
                if (combustible.getKmVehiculoInicial() <= 0) {
                    combustible.setKmVehiculoInicial(vehiculo.getKMFinal());
                }

                if (combustible.getKmVehiculoFinal() < combustible.getKmVehiculoInicial()) {
                    throw new IllegalArgumentException("El KM Final del vehículo no puede ser menor al KM Inicial");
                }

                double distanciaRecorrida = combustible.getKmVehiculoFinal() - combustible.getKmVehiculoInicial();
                combustible.setKilometros(distanciaRecorrida);

                // 4. Calcular Rendimiento del registro (individual)
                if (combustible.getConsumos() > 0) {
                    double rendimientoCarga = distanciaRecorrida / combustible.getConsumos();
                    combustible.setRendimiento(rendimientoCarga);
                }

                // 5. Actualizar estado del Vehículo (Global)
                // - Actualizar el odómetro actual del vehículo para la próxima carga
                vehiculo.setKMFinal(combustible.getKmVehiculoFinal());
                // - Recalcular kilometros totales según la diferencia (Dato del usuario)
                vehiculo.setKilometros(vehiculo.getKMFinal() - vehiculo.getKMinicial());

                // - Actualizar consumos totales y rendimiento global del vehículo
                if (combustible.getConsumos() > 0) {
                    double consumoAnterior = vehiculo.getConsumos();
                    double nuevoConsumoTotal = consumoAnterior + combustible.getConsumos();
                    vehiculo.setConsumos(nuevoConsumoTotal);

                    if (nuevoConsumoTotal > 0) {
                        vehiculo.setRendimiento(vehiculo.getKilometros() / nuevoConsumoTotal);
                    }
                }

                // Guardar cambios en el vehículo
                vehiculoRepository.save(vehiculo);
            }
        }
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

    public List<Combustible> listarCombustiblesPorVehiculo(@NonNull Long vehiculoId) {
        return combustibleRepository.findByVehiculoId(vehiculoId);
    }

}
