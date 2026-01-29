package gestion_vehiculos_combustible.Mapper;

import gestion_vehiculos_combustible.Dto.MaquinaDTO;
import gestion_vehiculos_combustible.Model.Maquina;
import org.springframework.stereotype.Component;

@Component
public class MaquinaMapper {

    public MaquinaDTO toDTO(Maquina maquina) {
        if (maquina == null)
            return null;
        MaquinaDTO dto = new MaquinaDTO();
        dto.setId(maquina.getId());
        dto.setKMinicial(maquina.getKMinicial());
        dto.setKMFinal(maquina.getKMFinal());
        dto.setKMTotales(maquina.getKMTotales());
        dto.setLitros(maquina.getLitros());
        return dto;
    }

    public Maquina toEntity(MaquinaDTO dto) {
        if (dto == null)
            return null;
        Maquina entity = new Maquina();
        entity.setId(dto.getId());
        entity.setKMinicial(dto.getKMinicial());
        entity.setKMFinal(dto.getKMFinal());
        entity.setKMTotales(dto.getKMTotales());
        entity.setLitros(dto.getLitros());
        return entity;
    }
}
