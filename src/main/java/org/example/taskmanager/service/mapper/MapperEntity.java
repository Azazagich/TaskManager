package org.example.taskmanager.service.mapper;

import org.mapstruct.Mapper;
import java.util.List;
import java.util.Optional;

@Mapper
public interface MapperEntity <Entity, DTO>{

    Entity toEntity(DTO dto);

    List<Entity> toEntities(List<DTO> dtos);

    DTO toDTO(Entity entity);

    Optional<DTO> toDTO(Optional<Entity> entity);

    List<DTO> toDTOS(List<Entity> entities);
}
