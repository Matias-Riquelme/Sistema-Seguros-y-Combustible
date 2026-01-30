package gestion_vehiculos_combustible.mapper;

import gestion_vehiculos_combustible.dto.ConductorDTO;
import gestion_vehiculos_combustible.model.Conductor;
import org.springframework.stereotype.Component;

@Component
public class ConductorMapper {

    public ConductorDTO toDTO(Conductor conductor) {
        if (conductor == null)
            return null;
        ConductorDTO dto = new ConductorDTO();
        dto.setId(conductor.getId());
        dto.setPrimerNombre(conductor.getPrimerNombre());
        dto.setSegundoNombre(conductor.getSegundoNombre());
        dto.setApellidoPaterno(conductor.getApellidoPaterno());
        dto.setApellidoMaterno(conductor.getApellidoMaterno());
        dto.setRut(conductor.getRut());
        dto.setTelefono(conductor.getTelefono());
        return dto;
    }

    public Conductor toEntity(ConductorDTO dto) {
        if (dto == null)
            return null;
        Conductor entity = new Conductor();
        entity.setId(dto.getId());
        entity.setPrimerNombre(dto.getPrimerNombre());
        entity.setSegundoNombre(dto.getSegundoNombre());
        entity.setApellidoPaterno(dto.getApellidoPaterno());
        entity.setApellidoMaterno(dto.getApellidoMaterno());
        entity.setRut(dto.getRut());
        entity.setTelefono(dto.getTelefono());
        return entity;
    }
}
