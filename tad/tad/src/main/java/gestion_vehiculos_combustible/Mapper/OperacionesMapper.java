package gestion_vehiculos_combustible.Mapper;

import gestion_vehiculos_combustible.Dto.OperacionesDTO;
import gestion_vehiculos_combustible.Model.Operaciones;
import org.springframework.stereotype.Component;

@Component
public class OperacionesMapper {

    public OperacionesDTO toDTO(Operaciones operaciones) {
        if (operaciones == null)
            return null;
        OperacionesDTO dto = new OperacionesDTO();
        dto.setId(operaciones.getId());
        dto.setNombre(operaciones.getNombre());
        dto.setConcepto(operaciones.getConcepto());
        dto.setRazonSocial(operaciones.getRazonSocial());
        return dto;
    }

    public Operaciones toEntity(OperacionesDTO dto) {
        if (dto == null)
            return null;
        Operaciones entity = new Operaciones();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setConcepto(dto.getConcepto());
        entity.setRazonSocial(dto.getRazonSocial());
        return entity;
    }
}
