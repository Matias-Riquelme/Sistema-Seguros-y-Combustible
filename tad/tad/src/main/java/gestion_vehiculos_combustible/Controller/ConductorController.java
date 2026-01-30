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

import gestion_vehiculos_combustible.Dto.ConductorDTO;
import gestion_vehiculos_combustible.Mapper.ConductorMapper;
import gestion_vehiculos_combustible.Model.Conductor;
import gestion_vehiculos_combustible.Service.ConductorService;

@RestController
@RequestMapping("/api/conductores")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @Autowired
    private ConductorMapper conductorMapper;

    @PostMapping
    public ResponseEntity<ConductorDTO> crearConductor(@RequestBody @NonNull ConductorDTO conductorDTO) {
        Conductor conductor = conductorMapper.toEntity(conductorDTO);
        if (conductor == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(conductorMapper.toDTO(conductorService.guardarConductor(conductor)));
    }

    @GetMapping
    public List<ConductorDTO> listarConductores() {
        return conductorService.listarConductores().stream()
                .map(conductorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConductorDTO> obtenerConductor(@PathVariable @NonNull Long id) {
        Optional<Conductor> conductor = conductorService.obtenerConductorPorId(id);
        return conductor.map(c -> ResponseEntity.ok(conductorMapper.toDTO(c)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarConductor(@PathVariable @NonNull Long id) {
        conductorService.eliminarConductor(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/actualizar/{id}")
    public ResponseEntity<ConductorDTO> actualizarConductor(@PathVariable @NonNull Long id,
            @RequestBody @NonNull ConductorDTO conductorDTO) {
        Optional<Conductor> conductorExistente = conductorService.obtenerConductorPorId(id);
        if (conductorExistente.isPresent()) {
            Conductor conductorActualizado = conductorExistente.get();
            conductorActualizado.setPrimerNombre(conductorDTO.getPrimerNombre());
            conductorActualizado.setSegundoNombre(conductorDTO.getSegundoNombre());
            conductorActualizado.setApellidoPaterno(conductorDTO.getApellidoPaterno());
            conductorActualizado.setApellidoMaterno(conductorDTO.getApellidoMaterno());
            conductorActualizado.setRut(conductorDTO.getRut());
            conductorActualizado.setTelefono(conductorDTO.getTelefono());

            return ResponseEntity.ok(conductorMapper.toDTO(conductorService.guardarConductor(conductorActualizado)));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
