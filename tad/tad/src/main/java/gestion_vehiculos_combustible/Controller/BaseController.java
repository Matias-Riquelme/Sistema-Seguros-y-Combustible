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

import gestion_vehiculos_combustible.dto.BaseDTO;
import gestion_vehiculos_combustible.mapper.BaseMapper;
import gestion_vehiculos_combustible.model.Base;
import gestion_vehiculos_combustible.service.BaseService;

@RestController
@RequestMapping("/api/bases")
public class BaseController {

    @Autowired
    private BaseService baseService;

    @Autowired
    private BaseMapper baseMapper;

    @PostMapping
    public ResponseEntity<BaseDTO> crearBase(@RequestBody @NonNull BaseDTO baseDTO) {
        Base base = baseMapper.toEntity(baseDTO);
        if (base == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(baseMapper.toDTO(baseService.guardarBase(base)));
    }

    @GetMapping
    public List<BaseDTO> listarBases() {
        return baseService.listarBases().stream()
                .map(baseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseDTO> obtenerBase(@PathVariable @NonNull Long id) {
        Optional<Base> base = baseService.obtenerBasePorId(id);
        return base.map(b -> ResponseEntity.ok(baseMapper.toDTO(b)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarBase(@PathVariable @NonNull Long id) {
        baseService.eliminarBase(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/actualizar/{id}")
    public ResponseEntity<BaseDTO> actualizarBase(@PathVariable @NonNull Long id,
            @RequestBody @NonNull BaseDTO baseDTO) {
        Optional<Base> baseExistente = baseService.obtenerBasePorId(id);
        if (baseExistente.isPresent()) {
            Base baseActualizado = baseExistente.get();
            baseActualizado.setNombre(baseDTO.getNombre());
            baseActualizado.setUbicacion(baseDTO.getUbicacion());
            return ResponseEntity.ok(baseMapper.toDTO(baseService.guardarBase(baseActualizado)));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
