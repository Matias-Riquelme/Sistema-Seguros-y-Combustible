package MicroservicioIncidenteSiniestros.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import MicroservicioIncidenteSiniestros.model.Pais;
import MicroservicioIncidenteSiniestros.services.PaisServices;

@RestController
@RequestMapping("/api/pais")
@CrossOrigin(origins = "*")
public class PaisController {

    @Autowired
    private PaisServices paisServices;

    @GetMapping("/listar")
    public List<Pais> listar() {
        return paisServices.listarPaises();
    }

    @GetMapping("/obtener/{id}")
    public Pais obtener(@PathVariable Integer id) {
        return paisServices.obtenerPaisPorId(id);
    }

    @PostMapping("/crear")
    public Pais crear(@RequestBody Pais pais) {
        return paisServices.crearPais(pais);
    }

    @PutMapping("/actualizar/{id}")
    public Pais actualizar(@PathVariable Integer id, @RequestBody Pais pais) {
        return paisServices.actualizarPais(id, pais);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        paisServices.eliminarPais(id);
    }
}
