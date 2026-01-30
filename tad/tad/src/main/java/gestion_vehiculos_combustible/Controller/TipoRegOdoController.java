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

import gestion_vehiculos_combustible.dto.TipoRegOdoDTO;
import gestion_vehiculos_combustible.mapper.TipoRegOdoMapper;
import gestion_vehiculos_combustible.model.TipoRegOdo;
import gestion_vehiculos_combustible.service.TipoRegOdoService;

@RestController
@RequestMapping("/api/tipo-reg-odo")
public class TipoRegOdoController {

    @Autowired
    private TipoRegOdoService tipoRegOdoService;

    @Autowired
    private TipoRegOdoMapper tipoRegOdoMapper;

    /**
     * Crea un nuevo tipo de registro de odómetro.
     * 
     * @param tipoRegOdoDTO Datos del tipo de registro a crear.
     * @return ResponseEntity con el tipo de registro creado.
     */
    @PostMapping
    public ResponseEntity<TipoRegOdoDTO> crearTipoRegOdo(@RequestBody @NonNull TipoRegOdoDTO tipoRegOdoDTO) {
        TipoRegOdo tipoRegOdo = tipoRegOdoMapper.toEntity(tipoRegOdoDTO);
        if (tipoRegOdo == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tipoRegOdoMapper.toDTO(tipoRegOdoService.guardarTipoRegOdo(tipoRegOdo)));
    }

    /**
     * Lista todos los tipos de registro de odómetro.
     * 
     * @return Lista de TipoRegOdoDTO.
     */
    @GetMapping
    public List<TipoRegOdoDTO> listarTipoRegOdo() {
        return tipoRegOdoService.listarTipoRegOdo().stream()
                .map(tipoRegOdoMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene un tipo de registro de odómetro por su ID.
     * 
     * @param id ID del tipo de registro.
     * @return ResponseEntity con el tipo de registro encontrado o 404.
     */
    @GetMapping("/{id}")
    public ResponseEntity<TipoRegOdoDTO> obtenerTipoRegOdo(@PathVariable @NonNull Long id) {
        Optional<TipoRegOdo> tipoRegOdo = tipoRegOdoService.obtenerTipoRegOdoPorId(id);
        return tipoRegOdo.map(t -> ResponseEntity.ok(tipoRegOdoMapper.toDTO(t)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Elimina un tipo de registro de odómetro por su ID.
     * 
     * @param id ID del tipo de registro a eliminar.
     * @return ResponseEntity con estado 204.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTipoRegOdo(@PathVariable @NonNull Long id) {
        tipoRegOdoService.eliminarTipoRegOdo(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Actualiza un tipo de registro de odómetro existente.
     * 
     * @param id            ID del tipo de registro a actualizar.
     * @param tipoRegOdoDTO Nuevos datos del tipo de registro.
     * @return ResponseEntity con el tipo de registro actualizado.
     */
    @PostMapping("/actualizar/{id}")
    public ResponseEntity<TipoRegOdoDTO> actualizarTipoRegOdo(@PathVariable @NonNull Long id,
            @RequestBody @NonNull TipoRegOdoDTO tipoRegOdoDTO) {
        Optional<TipoRegOdo> tipoRegOdoExistente = tipoRegOdoService.obtenerTipoRegOdoPorId(id);
        if (tipoRegOdoExistente.isPresent()) {
            TipoRegOdo tipoRegOdoActualizado = tipoRegOdoExistente.get();
            tipoRegOdoActualizado.setTipo_reg_odo(tipoRegOdoDTO.getTipo_reg_odo());
            return ResponseEntity
                    .ok(tipoRegOdoMapper.toDTO(tipoRegOdoService.guardarTipoRegOdo(tipoRegOdoActualizado)));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
