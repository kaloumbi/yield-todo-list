package com.yield.todo_list.service;

import com.yield.todo_list.dto.ProjectDTO;
import com.yield.todo_list.entity.Projet;

import java.util.List;

public interface ProjetService {
    ProjectDTO addProdject(ProjectDTO projetDto);

    List<ProjectDTO> getProjets();

    ProjectDTO getProjet(Long id);

    ProjectDTO updateProject(Long id, ProjectDTO projetDto);

    void deleteProject(Long id);

}
