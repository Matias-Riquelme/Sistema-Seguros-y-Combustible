package MicroservicioIncidenteSiniestros.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import MicroservicioIncidenteSiniestros.model.TipoIncidente;
import MicroservicioIncidenteSiniestros.services.TipoIncidenteServices;

@RestController
@RequestMapping("/api/tipo-incidente")
@CrossOrigin(origins = "*")
public class TipoIncidenteController {

    @Autowired
    private TipoIncidenteServices tipoIncidenteServices;

    @GetMapping("/listar")
    public List<TipoIncidente> listar() {
        return tipoIncidenteServices.listarTiposIncidente();
    }

    @GetMapping("/obtener/{id}")
    public TipoIncidente obtener(@PathVariable Integer id) {
        return tipoIncidenteServices.obtenerTipoIncidentePorId(id);
    }

    @PostMapping("/crear")
    public TipoIncidente crear(@RequestBody TipoIncidente tipoIncidente) {
        return tipoIncidenteServices.crearTipoIncidente(tipoIncidente);
    }

    @PutMapping("/actualizar/{id}")
    public TipoIncidente actualizar(@PathVariable Integer id, @RequestBody TipoIncidente tipoIncidente) {
        return tipoIncidenteServices.actualizarTipoIncidente(id, tipoIncidente);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        tipoIncidenteServices.eliminarTipoIncidente(id);
    }
}
