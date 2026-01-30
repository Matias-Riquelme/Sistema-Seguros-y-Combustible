package MicroservicioIncidenteSiniestros.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import MicroservicioIncidenteSiniestros.model.Tercero;
import MicroservicioIncidenteSiniestros.services.TerceroServices;

@RestController
@RequestMapping("/api/tercero")
@CrossOrigin(origins = "*")
public class TerceroController {

    @Autowired
    private TerceroServices terceroServices;

    @GetMapping("/listar")
    public List<Tercero> listar() {
        return terceroServices.listarTerceros();
    }

    @GetMapping("/obtener/{id}")
    public Tercero obtener(@PathVariable Integer id) {
        return terceroServices.obtenerTerceroPorId(id);
    }

    @PostMapping("/crear")
    public Tercero crear(@RequestBody Tercero tercero) {
        return terceroServices.crearTercero(tercero);
    }

    @PutMapping("/actualizar/{id}")
    public Tercero actualizar(@PathVariable Integer id, @RequestBody Tercero tercero) {
        return terceroServices.actualizarTercero(id, tercero);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        terceroServices.eliminarTercero(id);
    }
}
