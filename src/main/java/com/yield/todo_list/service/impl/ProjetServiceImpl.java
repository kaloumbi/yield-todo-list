package com.yield.todo_list.service.impl;

import com.yield.todo_list.dto.ProjectDTO;
import com.yield.todo_list.entity.Projet;
import com.yield.todo_list.enums.ETAT;
import com.yield.todo_list.mapper.ProjectMapper;
import com.yield.todo_list.repository.ProjetRepo;
import com.yield.todo_list.service.ProjetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjetServiceImpl implements ProjetService {

    private final ProjetRepo projetRepo;

    private final ProjectMapper projectMapper;

    @Override
    public ProjectDTO addProdject(ProjectDTO projetDto) {

        Projet projet = projectMapper.toEntity(projetDto);
        projet.setEtat(ETAT.ACTIF);

        projet = projetRepo.save(projet);
        return projectMapper.toDto(projet) ;
    }

    @Override
    public List<ProjectDTO> getProjets() {

        return projectMapper.toDto(projetRepo.findAll());
    }

    @Override
    public ProjectDTO getProjet(Long id) {

        Optional<Projet> projetSearch = projetRepo.findById(id);

        if (projetSearch.isEmpty()){
            throw new IllegalArgumentException("Aucun projet trouvé !");
        }
        Projet projetFound = projetSearch.get();

        return projectMapper.toDto(projetFound);
    }

    @Override
    public ProjectDTO updateProject(Long id, ProjectDTO projetDto) {
        Optional<Projet> projetSearch = projetRepo.findById(id);
        if (projetSearch.isEmpty()){
            throw new IllegalArgumentException("Aucun projet trouvé !");
        }
        Projet projetFound = projetSearch.get();
        if (projetDto.getId() == null){
            projetDto.setId(projetFound.getId());
        }
        projetFound = projectMapper.toEntity(projetDto);
        Projet projetUpdated = projetRepo.save(projetFound);

        return projectMapper.toDto(projetUpdated) ;
    }

    @Override
    public void deleteProject(Long id) {
        Optional<Projet> projetSearch = projetRepo.findById(id);
        if (projetSearch.isEmpty()){
            throw new IllegalArgumentException("Aucun project à supprimer !");
        }
        Projet projetFound = projetSearch.get();
        projetFound.setEtat(ETAT.SUPPRIME);

        projetRepo.save(projetFound);
    }
}
