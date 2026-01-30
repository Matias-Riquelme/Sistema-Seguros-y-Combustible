package gestion_vehiculos_combustible.Mapper;

import gestion_vehiculos_combustible.Dto.CombustibleDTO;
import gestion_vehiculos_combustible.Model.Combustible;
import org.springframework.stereotype.Component;

@Component
public class CombustibleMapper {

    public CombustibleDTO toDTO(Combustible combustible) {
        if (combustible == null)
            return null;
        CombustibleDTO dto = new CombustibleDTO();
        dto.setId(combustible.getId());
        dto.setNombre(combustible.getNombre());
        dto.setPrecio(combustible.getPrecio());
        dto.setConsumos(combustible.getConsumos());
        dto.setKilometraje(combustible.getKilometraje());
        dto.setRendimiento(combustible.getRendimiento());
        dto.setMes(combustible.getMes());
        dto.setMes2(combustible.getMes2());
        dto.setEstanque(combustible.getEstanque());
        return dto;
    }

    public Combustible toEntity(CombustibleDTO dto) {
        if (dto == null)
            return null;
        Combustible entity = new Combustible();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setPrecio(dto.getPrecio());
        entity.setConsumos(dto.getConsumos());
        entity.setKilometraje(dto.getKilometraje());
        entity.setRendimiento(dto.getRendimiento());
        entity.setMes(dto.getMes());
        entity.setMes2(dto.getMes2());
        entity.setEstanque(dto.getEstanque());
        return entity;
    }
}
