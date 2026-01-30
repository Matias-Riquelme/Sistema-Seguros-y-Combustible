package MicroservicioIncidenteSiniestros.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import MicroservicioIncidenteSiniestros.model.Asegurado;
import MicroservicioIncidenteSiniestros.services.AseguradoServices;

@RestController
@RequestMapping("/api/asegurado")
@CrossOrigin(origins = "*") // Esto es para que pueda recibir peticiones de otros microservicios
public class AseguradoController {

    @Autowired
    private AseguradoServices aseguradoServices;

    @GetMapping("/listar")
    public List<Asegurado> listar() {
        return aseguradoServices.listarAsegurados();
    }

    @GetMapping("/obtener/{id}")
    public Asegurado obtener(@PathVariable Integer id) {
        return aseguradoServices.obtenerAseguradoPorId(id);
    }

    @PostMapping("/crear")
    public Asegurado crear(@RequestBody Asegurado asegurado) {
        return aseguradoServices.crearAsegurado(asegurado);
    }

    @PutMapping("/actualizar/{id}")
    public Asegurado actualizar(@PathVariable Integer id, @RequestBody Asegurado asegurado) {
        return aseguradoServices.actualizarAsegurado(id, asegurado);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        aseguradoServices.eliminarAsegurado(id);
    }
}
