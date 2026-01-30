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

import gestion_vehiculos_combustible.dto.OdometroDTO;
import gestion_vehiculos_combustible.mapper.OdometroMapper;
import gestion_vehiculos_combustible.model.Odometro;
import gestion_vehiculos_combustible.service.OdometroService;

@RestController
@RequestMapping("/api/odometros")
public class OdometroController {

    @Autowired
    private OdometroService odometroService;

    @Autowired
    private OdometroMapper odometroMapper;

    /**
     * Crea un nuevo registro de odómetro.
     * 
     * @param odometroDTO Datos del odómetro a crear.
     * @return ResponseEntity con el odómetro creado.
     */
    @PostMapping
    public ResponseEntity<OdometroDTO> crearOdometro(@RequestBody @NonNull OdometroDTO odometroDTO) {
        Odometro odometro = odometroMapper.toEntity(odometroDTO);
        if (odometro == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(odometroMapper.toDTO(odometroService.guardarOdometro(odometro)));
    }

    /**
     * Lista todos los registros de odómetro.
     * 
     * @return Lista de OdometroDTO.
     */
    @GetMapping
    public List<OdometroDTO> listarOdometros() {
        return odometroService.listarOdometros().stream()
                .map(odometroMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Obtiene un registro de odómetro por su ID.
     * 
     * @param id ID del odómetro.
     * @return ResponseEntity con el odómetro encontrado o 404.
     */
    @GetMapping("/{id}")
    public ResponseEntity<OdometroDTO> obtenerOdometro(@PathVariable @NonNull Long id) {
        Optional<Odometro> odometro = odometroService.obtenerOdometroPorId(id);
        return odometro.map(o -> ResponseEntity.ok(odometroMapper.toDTO(o)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Elimina un registro de odómetro por su ID.
     * 
     * @param id ID del odómetro a eliminar.
     * @return ResponseEntity con estado 204.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOdometro(@PathVariable @NonNull Long id) {
        odometroService.eliminarOdometro(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Actualiza un registro de odómetro existente.
     * 
     * @param id          ID del odómetro a actualizar.
     * @param odometroDTO Nuevos datos del odómetro.
     * @return ResponseEntity con el odómetro actualizado.
     */
    @PostMapping("/actualizar/{id}")
    public ResponseEntity<OdometroDTO> actualizarOdometro(@PathVariable @NonNull Long id,
            @RequestBody @NonNull OdometroDTO odometroDTO) {
        Optional<Odometro> odometroExistente = odometroService.obtenerOdometroPorId(id);
        if (odometroExistente.isPresent()) {
            Odometro odometroActualizado = odometroExistente.get();
            odometroActualizado.setOdoActual(odometroDTO.getOdoActual());
            odometroActualizado.setF_toma_odo(odometroDTO.getF_toma_odo());
            odometroActualizado.setR_reg_odo(odometroDTO.getR_reg_odo());
            return ResponseEntity.ok(odometroMapper.toDTO(odometroService.guardarOdometro(odometroActualizado)));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
