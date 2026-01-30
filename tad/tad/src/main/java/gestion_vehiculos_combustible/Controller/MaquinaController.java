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

import gestion_vehiculos_combustible.Dto.MaquinaDTO;
import gestion_vehiculos_combustible.Mapper.MaquinaMapper;
import gestion_vehiculos_combustible.Model.Maquina;
import gestion_vehiculos_combustible.Service.MaquinaService;

@RestController
@RequestMapping("/api/maquinas")
public class MaquinaController {

    @Autowired
    private MaquinaService maquinaService;

    @Autowired
    private MaquinaMapper maquinaMapper;

    @PostMapping
    public ResponseEntity<MaquinaDTO> crearMaquina(@RequestBody @NonNull MaquinaDTO maquinaDTO) {
        Maquina maquina = maquinaMapper.toEntity(maquinaDTO);
        if (maquina == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(maquinaMapper.toDTO(maquinaService.guardarMaquina(maquina)));
    }

    @GetMapping
    public List<MaquinaDTO> listarMaquinas() {
        return maquinaService.listarMaquinas().stream()
                .map(maquinaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaquinaDTO> obtenerMaquina(@PathVariable @NonNull Long id) {
        Optional<Maquina> maquina = maquinaService.obtenerMaquinaPorId(id);
        return maquina.map(m -> ResponseEntity.ok(maquinaMapper.toDTO(m)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMaquina(@PathVariable @NonNull Long id) {
        maquinaService.eliminarMaquina(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/actualizar/{id}")
    public ResponseEntity<MaquinaDTO> actualizarMaquina(@PathVariable @NonNull Long id,
            @RequestBody @NonNull MaquinaDTO maquinaDTO) {
        Optional<Maquina> maquinaExistente = maquinaService.obtenerMaquinaPorId(id);
        if (maquinaExistente.isPresent()) {
            Maquina maquinaActualizado = maquinaExistente.get();
            maquinaActualizado.setKMinicial(maquinaDTO.getKMinicial());
            maquinaActualizado.setKMFinal(maquinaDTO.getKMFinal());
            maquinaActualizado.setKMTotales(maquinaDTO.getKMTotales());
            maquinaActualizado.setLitros(maquinaDTO.getLitros());
            return ResponseEntity.ok(maquinaMapper.toDTO(maquinaService.guardarMaquina(maquinaActualizado)));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
