package gestion_vehiculos_combustible.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.lang.NonNull;

import gestion_vehiculos_combustible.dto.VehiculoDTO;
import gestion_vehiculos_combustible.mapper.VehiculoMapper;
import gestion_vehiculos_combustible.model.Vehiculo;
import gestion_vehiculos_combustible.service.VehiculoService;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @Autowired
    private VehiculoMapper vehiculoMapper;

    /**
     * Crea un nuevo vehículo.
     * 
     * @param vehiculoDTO Datos del vehículo a crear.
     * @return ResponseEntity con el vehículo creado.
     */
    @PostMapping
    public ResponseEntity<VehiculoDTO> crearVehiculo(@RequestBody @NonNull VehiculoDTO vehiculoDTO) {
        Vehiculo vehiculo = vehiculoMapper.toEntity(vehiculoDTO);
        if (vehiculo == null) {
            return ResponseEntity.badRequest().build();
        }
        Vehiculo guardado = vehiculoService.guardarVehiculo(vehiculo);
        return ResponseEntity.ok(vehiculoMapper.toDTO(guardado));
    }

    /**
     * Lista todos los vehículos registrados.
     * 
     * @return Lista de VehiculoDTO.
     */
    @GetMapping
    public List<VehiculoDTO> listarVehiculos() {
        return vehiculoService.listarVehiculos()
                .stream()
                .map(vehiculoMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene un vehículo por su ID o patente (vía service).
     * 
     * @param id ID del vehículo.
     * @return ResponseEntity con el vehículo encontrado o 404.
     */
    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDTO> obtenerVehiculo(@PathVariable @NonNull Long id) {
        Optional<Vehiculo> vehiculo = vehiculoService.obtenerVehiculoPorId(id);
        return vehiculo.map(v -> ResponseEntity.ok(vehiculoMapper.toDTO(v)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Elimina un vehículo por su ID.
     * 
     * @param id ID del vehículo a eliminar.
     * @return ResponseEntity con estado 204.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVehiculo(@PathVariable @NonNull Long id) {
        vehiculoService.eliminarVehiculo(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Actualiza la información de un vehículo existente.
     * Incluye datos técnicos como número de motor y chasis.
     * 
     * @param id          ID del vehículo a actualizar.
     * @param vehiculoDTO Nuevos datos del vehículo.
     * @return ResponseEntity con el vehículo actualizado.
     */
    @PostMapping("/actualizar/{id}")
    public ResponseEntity<VehiculoDTO> actualizarVehiculo(@PathVariable @NonNull Long id,
            @RequestBody @NonNull VehiculoDTO vehiculoDTO) {
        Optional<Vehiculo> vehiculoExistente = vehiculoService.obtenerVehiculoPorId(id);
        if (vehiculoExistente.isPresent()) {
            Vehiculo vehiculoActualizado = vehiculoExistente.get();
            vehiculoActualizado.setMarca(vehiculoDTO.getMarca());
            vehiculoActualizado.setModelo(vehiculoDTO.getModelo());
            vehiculoActualizado.setTipo(vehiculoDTO.getTipo());
            vehiculoActualizado.setRampla(vehiculoDTO.getRampla());
            vehiculoActualizado.setAnio(vehiculoDTO.getAnio());
            vehiculoActualizado.setAnioRegistro(vehiculoDTO.getAnioRegistro());
            vehiculoActualizado.setNum_motor_veh(vehiculoDTO.getNum_motor_veh());
            vehiculoActualizado.setNum_chasis_veh(vehiculoDTO.getNum_chasis_veh());

            Vehiculo guardado = vehiculoService.guardarVehiculo(vehiculoActualizado);
            return ResponseEntity.ok(vehiculoMapper.toDTO(guardado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
