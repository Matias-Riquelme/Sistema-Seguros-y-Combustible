package MicroservicioIncidenteSiniestros.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import MicroservicioIncidenteSiniestros.model.EstadoSiniestro;
import MicroservicioIncidenteSiniestros.services.EstadoSiniestroServices;

@RestController
@RequestMapping("/api/estado-siniestro")
@CrossOrigin(origins = "*")
public class EstadoSiniestroController {

    @Autowired
    private EstadoSiniestroServices estadoSiniestroServices;

    @GetMapping("/listar")
    public List<EstadoSiniestro> listar() {
        return estadoSiniestroServices.listarEstadosSiniestro();
    }

    @GetMapping("/obtener/{id}")
    public EstadoSiniestro obtener(@PathVariable Integer id) {
        return estadoSiniestroServices.obtenerEstadoSiniestroPorId(id);
    }

    @PostMapping("/crear")
    public EstadoSiniestro crear(@RequestBody EstadoSiniestro estadoSiniestro) {
        return estadoSiniestroServices.crearEstadoSiniestro(estadoSiniestro);
    }

    @PutMapping("/actualizar/{id}")
    public EstadoSiniestro actualizar(@PathVariable Integer id, @RequestBody EstadoSiniestro estadoSiniestro) {
        return estadoSiniestroServices.actualizarEstadoSiniestro(id, estadoSiniestro);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        estadoSiniestroServices.eliminarEstadoSiniestro(id);
    }
}
