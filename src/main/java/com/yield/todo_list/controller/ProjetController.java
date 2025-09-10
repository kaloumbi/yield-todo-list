package com.yield.todo_list.controller;


import com.yield.todo_list.dto.ProjectDTO;
import com.yield.todo_list.service.ProjetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class ProjetController {

    private final ProjetService projetService;

    @PostMapping("/projet/added")
    public ResponseEntity<ProjectDTO> addProjet(@RequestBody ProjectDTO projectDTO){
        ProjectDTO projetAdd = projetService.addProdject(projectDTO);

        return new ResponseEntity<>(projetAdd, HttpStatus.OK);
    }

    @GetMapping("/projet/list")
    public ResponseEntity<List<ProjectDTO>> getAllProjects(){
        List<ProjectDTO> projectDTOList = projetService.getProjets();

        return new ResponseEntity<>(projectDTOList, HttpStatus.OK);
    }

    @GetMapping("/project/{id}/detail")
    public ResponseEntity<ProjectDTO> detailProject(@PathVariable Long id){
        ProjectDTO detailProject = projetService.getProjet(id);

        return new ResponseEntity<>(detailProject, HttpStatus.OK);
    }

    @PutMapping("/project/{id}/updated")
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable Long id, @RequestBody ProjectDTO projectDTO){

        ProjectDTO projectUp = projetService.updateProject(id, projectDTO);

        return new ResponseEntity<>(projectUp, HttpStatus.OK);
    }

    @DeleteMapping("/project/{id}/deleted")
    public ResponseEntity<String> deleteProject(@PathVariable Long id){

        projetService.deleteProject(id);
        return new ResponseEntity<>("Project supprime avec succes !", HttpStatus.OK);
    }
}
