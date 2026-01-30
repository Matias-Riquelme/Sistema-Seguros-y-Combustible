package MicroservicioIncidenteSiniestros.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import MicroservicioIncidenteSiniestros.model.Region;
import MicroservicioIncidenteSiniestros.services.RegionServices;

@RestController
@RequestMapping("/api/region")
@CrossOrigin(origins = "*")
public class RegionController {

    @Autowired
    private RegionServices regionServices;

    @GetMapping("/listar")
    public List<Region> listar() {
        return regionServices.listarRegiones();
    }

    @GetMapping("/obtener/{id}")
    public Region obtener(@PathVariable Integer id) {
        return regionServices.obtenerRegionPorId(id);
    }

    @PostMapping("/crear")
    public Region crear(@RequestBody Region region) {
        return regionServices.crearRegion(region);
    }

    @PutMapping("/actualizar/{id}")
    public Region actualizar(@PathVariable Integer id, @RequestBody Region region) {
        return regionServices.actualizarRegion(id, region);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        regionServices.eliminarRegion(id);
    }
}
