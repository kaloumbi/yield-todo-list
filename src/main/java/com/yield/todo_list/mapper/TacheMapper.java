package com.yield.todo_list.mapper;

import com.yield.todo_list.dto.TacheDTO;
import com.yield.todo_list.entity.Tache;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TacheMapper extends EntityMapper<TacheDTO, Tache> {
    @Override
    @Mapping(target = "projet", ignore = true)
    Tache toEntity(TacheDTO dto);

    @Override
    @Mapping(target = "projectDTO.id", source = "projet.id")
    TacheDTO toDto(Tache entity);
}
