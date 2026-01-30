package MicroservicioIncidenteSiniestros.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import MicroservicioIncidenteSiniestros.model.TipoPoliza;
import MicroservicioIncidenteSiniestros.services.TipoPolizaServices;

@RestController
@RequestMapping("/api/tipo-poliza")
@CrossOrigin(origins = "*")
public class TipoPolizaController {

    @Autowired
    private TipoPolizaServices tipoPolizaServices;

    @GetMapping("/listar")
    public List<TipoPoliza> listar() {
        return tipoPolizaServices.listarTiposPoliza();
    }

    @GetMapping("/obtener/{id}")
    public TipoPoliza obtener(@PathVariable Integer id) {
        return tipoPolizaServices.obtenerTipoPolizaPorId(id);
    }

    @PostMapping("/crear")
    public TipoPoliza crear(@RequestBody TipoPoliza tipoPoliza) {
        return tipoPolizaServices.crearTipoPoliza(tipoPoliza);
    }

    @PutMapping("/actualizar/{id}")
    public TipoPoliza actualizar(@PathVariable Integer id, @RequestBody TipoPoliza tipoPoliza) {
        return tipoPolizaServices.actualizarTipoPoliza(id, tipoPoliza);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        tipoPolizaServices.eliminarTipoPoliza(id);
    }
}
