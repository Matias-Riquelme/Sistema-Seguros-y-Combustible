package MicroservicioIncidenteSiniestros.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import MicroservicioIncidenteSiniestros.model.Poliza;
import MicroservicioIncidenteSiniestros.services.PolizaServices;

@RestController
@RequestMapping("/api/poliza")
@CrossOrigin(origins = "*")
public class PolizaController {

    @Autowired
    private PolizaServices polizaServices;

    @GetMapping("/listar")
    public List<Poliza> listar() {
        return polizaServices.listarPolizas();
    }

    @GetMapping("/obtener/{id}")
    public Poliza obtener(@PathVariable Integer id) {
        return polizaServices.obtenerPolizaPorId(id);
    }

    @PostMapping("/crear")
    public Poliza crear(@RequestBody Poliza poliza) {
        return polizaServices.crearPoliza(poliza);
    }

    @PutMapping("/actualizar/{id}")
    public Poliza actualizar(@PathVariable Integer id, @RequestBody Poliza poliza) {
        return polizaServices.actualizarPoliza(id, poliza);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        polizaServices.eliminarPoliza(id);
    }

    @GetMapping("/por-siniestro/{idSin}")
    public Poliza obtenerPorSiniestro(@PathVariable Integer idSin) {
        return polizaServices.obtenerPolizaAsociadaASiniestro(idSin);
    }

    @GetMapping("/contar-siniestros/{idPol}")
    public Long contarSiniestros(@PathVariable Integer idPol) {
        return polizaServices.contarSiniestrosPorPoliza(idPol);
    }
}
