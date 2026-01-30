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

import gestion_vehiculos_combustible.dto.OperacionesDTO;
import gestion_vehiculos_combustible.mapper.OperacionesMapper;
import gestion_vehiculos_combustible.model.Operaciones;
import gestion_vehiculos_combustible.service.OperacionesService;

@RestController
@RequestMapping("/api/operaciones")
public class OperacionesController {

    @Autowired
    private OperacionesService operacionesService;

    @Autowired
    private OperacionesMapper operacionesMapper;

    /**
     * Crea una nueva operación.
     * 
     * @param operacionesDTO Datos de la operación a crear.
     * @return ResponseEntity con la operación creada.
     */
    @PostMapping
    public ResponseEntity<OperacionesDTO> crearOperaciones(@RequestBody @NonNull OperacionesDTO operacionesDTO) {
        Operaciones operaciones = operacionesMapper.toEntity(operacionesDTO);
        if (operaciones == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(operacionesMapper.toDTO(operacionesService.guardarOperaciones(operaciones)));
    }

    /**
     * Lista todas las operaciones registradas.
     * 
     * @return Lista de OperacionesDTO.
     */
    @GetMapping
    public List<OperacionesDTO> listarOperaciones() {
        return operacionesService.listarOperaciones().stream()
                .map(operacionesMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene una operación por su ID.
     * 
     * @param id ID de la operación.
     * @return ResponseEntity con la operación encontrada o 404.
     */
    @GetMapping("/{id}")
    public ResponseEntity<OperacionesDTO> obtenerOperaciones(@PathVariable @NonNull Long id) {
        Optional<Operaciones> operaciones = operacionesService.obtenerOperacionesPorId(id);
        return operaciones.map(o -> ResponseEntity.ok(operacionesMapper.toDTO(o)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Elimina una operación por su ID.
     * 
     * @param id ID de la operación a eliminar.
     * @return ResponseEntity con estado 204.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOperaciones(@PathVariable @NonNull Long id) {
        operacionesService.eliminarOperaciones(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Actualiza una operación existente.
     * 
     * @param id             ID de la operación a actualizar.
     * @param operacionesDTO Nuevos datos de la operación.
     * @return ResponseEntity con la operación actualizada.
     */
    @PostMapping("/actualizar/{id}")
    public ResponseEntity<OperacionesDTO> actualizarOperaciones(@PathVariable @NonNull Long id,
            @RequestBody @NonNull OperacionesDTO operacionesDTO) {
        Optional<Operaciones> operacionesExistente = operacionesService.obtenerOperacionesPorId(id);
        if (operacionesExistente.isPresent()) {
            Operaciones operacionesActualizado = operacionesExistente.get();
            operacionesActualizado.setNombre(operacionesDTO.getNombre());
            return ResponseEntity
                    .ok(operacionesMapper.toDTO(operacionesService.guardarOperaciones(operacionesActualizado)));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
