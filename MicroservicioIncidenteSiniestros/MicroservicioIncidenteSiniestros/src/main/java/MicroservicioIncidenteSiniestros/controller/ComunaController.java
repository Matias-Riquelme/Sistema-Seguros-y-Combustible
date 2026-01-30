package MicroservicioIncidenteSiniestros.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import MicroservicioIncidenteSiniestros.model.Comuna;
import MicroservicioIncidenteSiniestros.services.ComunaServices;

@RestController
@RequestMapping("/api/comuna")
@CrossOrigin(origins = "*")
public class ComunaController {

    @Autowired
    private ComunaServices comunaServices;

    @GetMapping("/listar")
    public List<Comuna> listar() {
        return comunaServices.listarComunas();
    }

    @GetMapping("/obtener/{id}")
    public Comuna obtener(@PathVariable Integer id) {
        return comunaServices.obtenerComunaPorId(id);
    }

    @PostMapping("/crear")
    public Comuna crear(@RequestBody Comuna comuna) {
        return comunaServices.crearComuna(comuna);
    }

    @PutMapping("/actualizar/{id}")
    public Comuna actualizar(@PathVariable Integer id, @RequestBody Comuna comuna) {
        return comunaServices.actualizarComuna(id, comuna);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        comunaServices.eliminarComuna(id);
    }
}
