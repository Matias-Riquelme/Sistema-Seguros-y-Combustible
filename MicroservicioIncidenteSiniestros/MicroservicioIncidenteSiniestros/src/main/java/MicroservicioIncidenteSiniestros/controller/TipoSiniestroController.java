package MicroservicioIncidenteSiniestros.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import MicroservicioIncidenteSiniestros.model.TipoSiniestro;
import MicroservicioIncidenteSiniestros.services.TipoSiniestroServices;

@RestController
@RequestMapping("/api/tipo-siniestro")
@CrossOrigin(origins = "*")
public class TipoSiniestroController {

    @Autowired
    private TipoSiniestroServices tipoSiniestroServices;

    @GetMapping("/listar")
    public List<TipoSiniestro> listar() {
        return tipoSiniestroServices.listarTiposSiniestro();
    }

    @GetMapping("/obtener/{id}")
    public TipoSiniestro obtener(@PathVariable Integer id) {
        return tipoSiniestroServices.obtenerTipoSiniestroPorId(id);
    }

    @PostMapping("/crear")
    public TipoSiniestro crear(@RequestBody TipoSiniestro tipoSiniestro) {
        return tipoSiniestroServices.crearTipoSiniestro(tipoSiniestro);
    }

    @PutMapping("/actualizar/{id}")
    public TipoSiniestro actualizar(@PathVariable Integer id, @RequestBody TipoSiniestro tipoSiniestro) {
        return tipoSiniestroServices.actualizarTipoSiniestro(id, tipoSiniestro);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        tipoSiniestroServices.eliminarTipoSiniestro(id);
    }
}
