package MicroservicioIncidenteSiniestros.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import MicroservicioIncidenteSiniestros.model.Cierre;
import MicroservicioIncidenteSiniestros.services.CierreServices;

@RestController
@RequestMapping("/api/cierre")
@CrossOrigin(origins = "*")
public class CierreController {

    @Autowired
    private CierreServices cierreServices;

    @GetMapping("/listar")
    public List<Cierre> listar() {
        return cierreServices.listarCierres();
    }

    @GetMapping("/obtener/{id}")
    public Cierre obtener(@PathVariable Integer id) {
        return cierreServices.obtenerCierrePorId(id);
    }

    @PostMapping("/crear")
    public Cierre crear(@RequestBody Cierre cierre) {
        return cierreServices.crearCierre(cierre);
    }

    @PutMapping("/actualizar/{id}")
    public Cierre actualizar(@PathVariable Integer id, @RequestBody Cierre cierre) {
        return cierreServices.actualizarCierre(id, cierre);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        cierreServices.eliminarCierre(id);
    }
}
