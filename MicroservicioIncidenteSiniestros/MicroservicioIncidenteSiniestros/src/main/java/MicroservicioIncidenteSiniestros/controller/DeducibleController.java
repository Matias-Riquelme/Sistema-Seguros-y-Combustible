package MicroservicioIncidenteSiniestros.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import MicroservicioIncidenteSiniestros.model.Deducible;
import MicroservicioIncidenteSiniestros.services.DeducibleServices;

@RestController
@RequestMapping("/api/deducible")
@CrossOrigin(origins = "*")
public class DeducibleController {

    @Autowired
    private DeducibleServices deducibleServices;

    @GetMapping("/listar")
    public List<Deducible> listar() {
        return deducibleServices.listarDeducibles();
    }

    @GetMapping("/obtener/{id}")
    public Deducible obtener(@PathVariable Integer id) {
        return deducibleServices.obtenerDeduciblePorId(id);
    }

    @PostMapping("/crear")
    public Deducible crear(@RequestBody Deducible deducible) {
        return deducibleServices.crearDeducible(deducible);
    }

    @PutMapping("/actualizar/{id}")
    public Deducible actualizar(@PathVariable Integer id, @RequestBody Deducible deducible) {
        return deducibleServices.actualizarDeducible(id, deducible);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        deducibleServices.eliminarDeducible(id);
    }
}
