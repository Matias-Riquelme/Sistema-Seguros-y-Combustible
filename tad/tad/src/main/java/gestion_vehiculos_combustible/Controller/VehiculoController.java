package gestion_vehiculos_combustible.Controller;

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

import gestion_vehiculos_combustible.Dto.VehiculoDTO;
import gestion_vehiculos_combustible.Mapper.VehiculoMapper;
import gestion_vehiculos_combustible.Model.Vehiculo;
import gestion_vehiculos_combustible.Service.VehiculoService;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @Autowired
    private VehiculoMapper vehiculoMapper;

    @PostMapping
    public ResponseEntity<VehiculoDTO> crearVehiculo(@RequestBody @NonNull VehiculoDTO vehiculoDTO) {
        Vehiculo vehiculo = vehiculoMapper.toEntity(vehiculoDTO);
        if (vehiculo == null) {
            return ResponseEntity.badRequest().build();
        }
        Vehiculo guardado = vehiculoService.guardarVehiculo(vehiculo);
        return ResponseEntity.ok(vehiculoMapper.toDTO(guardado));
    }

    @GetMapping
    public List<VehiculoDTO> listarVehiculos() {
        return vehiculoService.listarVehiculos()
                .stream()
                .map(vehiculoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDTO> obtenerVehiculo(@PathVariable @NonNull Long id) {
        Optional<Vehiculo> vehiculo = vehiculoService.obtenerVehiculoPorId(id);
        return vehiculo.map(v -> ResponseEntity.ok(vehiculoMapper.toDTO(v)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVehiculo(@PathVariable @NonNull Long id) {
        vehiculoService.eliminarVehiculo(id);
        return ResponseEntity.noContent().build();
    }

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

            Vehiculo guardado = vehiculoService.guardarVehiculo(vehiculoActualizado);
            return ResponseEntity.ok(vehiculoMapper.toDTO(guardado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
