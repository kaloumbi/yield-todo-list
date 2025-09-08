package com.yield.todo_list.mapper;

import com.yield.todo_list.dto.ProjectDTO;
import com.yield.todo_list.entity.Projet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper extends EntityMapper<ProjectDTO, Projet> {

}
