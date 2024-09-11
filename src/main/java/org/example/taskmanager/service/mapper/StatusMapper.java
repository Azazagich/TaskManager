package org.example.taskmanager.service.mapper;

import org.example.taskmanager.domain.Status;
import org.example.taskmanager.service.dto.StatusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper
public interface StatusMapper {

    Status toStatus(StatusDTO statusDTO);

    List<Status> toStatus(List<StatusDTO> statusesDTO);

    StatusDTO toStatusDTO(Status status);

    Optional<StatusDTO> toStatusDTO(Optional<Status> status);

    List<StatusDTO> toStatusDTOS(List<Status> status);
}
