package MicroservicioIncidenteSiniestros.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import MicroservicioIncidenteSiniestros.model.Siniestro;
import MicroservicioIncidenteSiniestros.services.SiniestroServices;

@RestController
@RequestMapping("/api/siniestro")
@CrossOrigin(origins = "*")
public class SiniestroController {

    @Autowired
    private SiniestroServices siniestroServices;

    @GetMapping("/listar")
    public List<Siniestro> listar() {
        return siniestroServices.listarSiniestros();
    }

    @GetMapping("/obtener/{id}")
    public Siniestro obtener(@PathVariable Integer id) {
        return siniestroServices.obtenerSiniestroPorId(id);
    }

    @PostMapping("/crear")
    public Siniestro crear(@RequestBody Siniestro siniestro) {
        return siniestroServices.crearSiniestro(siniestro);
    }

    @PutMapping("/actualizar/{id}")
    public Siniestro actualizar(@PathVariable Integer id, @RequestBody Siniestro siniestro) {
        return siniestroServices.actualizarSiniestro(id, siniestro);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        siniestroServices.eliminarSiniestro(id);
    }

    @GetMapping("/contar-mes-ano")
    public Long contarPorMesYAno(@RequestParam Integer mes, @RequestParam Integer ano) {
        return siniestroServices.countByMonthAndYear(mes, ano);
    }

    @GetMapping("/contar-ano/{ano}")
    public Long contarPorAno(@PathVariable Integer ano) {
        return siniestroServices.countByYear(ano);
    }

    @GetMapping("/contar-por-poliza/{polizaId}")
    public Long contarPorPoliza(@PathVariable Integer polizaId) {
        return siniestroServices.countByPolizaId(polizaId);
    }

    @GetMapping("/contar-por-incidente/{incidenteId}")
    public Long contarPorIncidente(@PathVariable Integer incidenteId) {
        return siniestroServices.countByIncidenteId(incidenteId);
    }
}
