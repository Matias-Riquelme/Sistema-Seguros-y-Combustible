package gestion_vehiculos_combustible.mapper;

import gestion_vehiculos_combustible.dto.MaquinaDTO;
import gestion_vehiculos_combustible.model.Maquina;
import org.springframework.stereotype.Component;

@Component
public class MaquinaMapper {

    public MaquinaDTO toDTO(Maquina maquina) {
        if (maquina == null)
            return null;
        MaquinaDTO dto = new MaquinaDTO();
        dto.setId(maquina.getId());
        dto.setSInicial(maquina.getSInicial());
        dto.setSFinal(maquina.getSFinal());
        dto.setLitros(maquina.getLitros());
        return dto;
    }

    public Maquina toEntity(MaquinaDTO dto) {
        if (dto == null)
            return null;
        Maquina entity = new Maquina();
        entity.setId(dto.getId());
        entity.setSInicial(dto.getSInicial());
        entity.setSFinal(dto.getSFinal());
        entity.setLitros(dto.getLitros());
        return entity;
    }
}
