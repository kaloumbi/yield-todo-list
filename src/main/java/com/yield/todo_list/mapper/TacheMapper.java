package com.yield.todo_list.mapper;

import com.yield.todo_list.dto.TacheDTO;
import com.yield.todo_list.entity.Tache;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TacheMapper extends EntityMapper<TacheDTO, Tache> {
    
}
