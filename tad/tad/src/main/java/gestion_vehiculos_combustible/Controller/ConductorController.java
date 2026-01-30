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

import gestion_vehiculos_combustible.dto.ConductorDTO;
import gestion_vehiculos_combustible.mapper.ConductorMapper;
import gestion_vehiculos_combustible.model.Conductor;
import gestion_vehiculos_combustible.service.ConductorService;

@RestController
@RequestMapping("/api/conductores")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @Autowired
    private ConductorMapper conductorMapper;

    /**
     * Crea un nuevo conductor.
     * 
     * @param conductorDTO Datos del conductor a crear.
     * @return ResponseEntity con el conductor creado.
     */
    @PostMapping
    public ResponseEntity<ConductorDTO> crearConductor(@RequestBody @NonNull ConductorDTO conductorDTO) {
        Conductor conductor = conductorMapper.toEntity(conductorDTO);
        if (conductor == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(conductorMapper.toDTO(conductorService.guardarConductor(conductor)));
    }

    /**
     * Lista todos los conductores registrados.
     * 
     * @return Lista de ConductorDTO.
     */
    @GetMapping
    public List<ConductorDTO> listarConductores() {
        return conductorService.listarConductores().stream()
                .map(conductorMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene un conductor por su ID.
     * 
     * @param id ID del conductor.
     * @return ResponseEntity con el conductor encontrado o 404.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ConductorDTO> obtenerConductor(@PathVariable @NonNull Long id) {
        Optional<Conductor> conductor = conductorService.obtenerConductorPorId(id);
        return conductor.map(c -> ResponseEntity.ok(conductorMapper.toDTO(c)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Elimina un conductor por su ID.
     * 
     * @param id ID del conductor a eliminar.
     * @return ResponseEntity con estado 204.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarConductor(@PathVariable @NonNull Long id) {
        conductorService.eliminarConductor(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Actualiza un conductor existente.
     * 
     * @param id           ID del conductor a actualizar.
     * @param conductorDTO Nuevos datos del conductor.
     * @return ResponseEntity con el conductor actualizado.
     */
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
            conductorActualizado.setDireccion(conductorDTO.getDireccion());

            return ResponseEntity.ok(conductorMapper.toDTO(conductorService.guardarConductor(conductorActualizado)));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
