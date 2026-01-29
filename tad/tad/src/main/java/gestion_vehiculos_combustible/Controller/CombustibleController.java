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

import gestion_vehiculos_combustible.Dto.CombustibleDTO;
import gestion_vehiculos_combustible.Mapper.CombustibleMapper;
import gestion_vehiculos_combustible.Model.Combustible;
import gestion_vehiculos_combustible.Service.CombustibleService;

@RestController
@RequestMapping("/api/combustible")
public class CombustibleController {

    @Autowired
    private CombustibleService combustibleService;

    @Autowired
    private CombustibleMapper combustibleMapper;

    @PostMapping
    public ResponseEntity<CombustibleDTO> registrarCombustible(@RequestBody @NonNull CombustibleDTO combustibleDTO) {
        Combustible combustible = combustibleMapper.toEntity(combustibleDTO);
        if (combustible == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(combustibleMapper.toDTO(combustibleService.guardarCombustible(combustible)));
    }

    @GetMapping
    public List<CombustibleDTO> listarCombustibles() {
        return combustibleService.listarCombustibles().stream()
                .map(combustibleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CombustibleDTO> obtenerCombustible(@PathVariable @NonNull Long id) {
        Optional<Combustible> combustible = combustibleService.obtenerCombustiblePorId(id);
        return combustible.map(c -> ResponseEntity.ok(combustibleMapper.toDTO(c)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCombustible(@PathVariable @NonNull Long id) {
        combustibleService.eliminarCombustible(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/actualizar/{id}")
    public ResponseEntity<CombustibleDTO> actualizarCombustible(@PathVariable @NonNull Long id,
            @RequestBody @NonNull CombustibleDTO combustibleDTO) {
        Optional<Combustible> combustibleExistente = combustibleService.obtenerCombustiblePorId(id);
        if (combustibleExistente.isPresent()) {
            Combustible combustibleActualizado = combustibleExistente.get();
            combustibleActualizado.setNombre(combustibleDTO.getNombre());
            combustibleActualizado.setPrecio(combustibleDTO.getPrecio());
            combustibleActualizado.setConsumos(combustibleDTO.getConsumos());
            combustibleActualizado.setKilometraje(combustibleDTO.getKilometraje());
            combustibleActualizado.setRendimiento(combustibleDTO.getRendimiento());
            combustibleActualizado.setMes(combustibleDTO.getMes());
            combustibleActualizado.setMes2(combustibleDTO.getMes2());
            combustibleActualizado.setEstanque(combustibleDTO.getEstanque());
            return ResponseEntity
                    .ok(combustibleMapper.toDTO(combustibleService.guardarCombustible(combustibleActualizado)));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
