package MicroservicioIncidenteSiniestros.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import MicroservicioIncidenteSiniestros.model.Cobertura;
import MicroservicioIncidenteSiniestros.services.CoberturaServices;

@RestController
@RequestMapping("/api/cobertura")
@CrossOrigin(origins = "*")
public class CoberturaController {

    @Autowired
    private CoberturaServices coberturaServices;

    @GetMapping("/listar")
    public List<Cobertura> listar() {
        return coberturaServices.listarCoberturas();
    }

    @GetMapping("/obtener/{id}")
    public Cobertura obtener(@PathVariable Integer id) {
        return coberturaServices.obtenerCoberturaPorId(id);
    }

    @PostMapping("/crear")
    public Cobertura crear(@RequestBody Cobertura cobertura) {
        return coberturaServices.crearCobertura(cobertura);
    }

    @PutMapping("/actualizar/{id}")
    public Cobertura actualizar(@PathVariable Integer id, @RequestBody Cobertura cobertura) {
        return coberturaServices.actualizarCobertura(id, cobertura);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        coberturaServices.eliminarCobertura(id);
    }
}
