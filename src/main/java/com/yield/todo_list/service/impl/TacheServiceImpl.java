package com.yield.todo_list.service.impl;

import com.yield.todo_list.dto.TacheDTO;
import com.yield.todo_list.entity.Projet;
import com.yield.todo_list.entity.Tache;
import com.yield.todo_list.enums.ETAT;
import com.yield.todo_list.mapper.ProjectMapper;
import com.yield.todo_list.mapper.TacheMapper;
import com.yield.todo_list.repository.ProjetRepo;
import com.yield.todo_list.repository.TacheRepo;
import com.yield.todo_list.service.TacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TacheServiceImpl implements TacheService {

    private final TacheRepo tacheRepo;

    private final ProjetRepo projetRepo;

    private final TacheMapper tacheMapper;

    private final ProjectMapper projectMapper;


    @Override
    public TacheDTO addTache(TacheDTO tacheDTO) {

        Optional<Projet> optionalProjet = projetRepo.findById(tacheDTO.getProjectDTO().getId());
        if (optionalProjet.isEmpty())
            throw new RuntimeException();

        Projet projet = optionalProjet.get();
        Tache tache = tacheMapper.toEntity(tacheDTO);
        tache.setEtat(ETAT.ACTIF);

        tache.setProjet(projet);

        tache = tacheRepo.save(tache);

        return tacheMapper.toDto(tache) ;
    }

    @Override
    public List<TacheDTO> getTaches() {
        List<Tache> tacheList = tacheRepo.findAll();
        return tacheMapper.toDto(tacheList);
    }

    @Override
    public TacheDTO getTache(Long id) {
        Optional<Tache> tacheSearch = tacheRepo.findById(id);
        if (tacheSearch.isEmpty()){
            throw new IllegalArgumentException("Tache introuvable !");
        }
        Tache tacheFound = tacheSearch.get();
        return tacheMapper.toDto(tacheFound);
    }

    @Override
    public TacheDTO updateTache(Long id, TacheDTO tacheDTO) {
        Tache tacheFound = tacheRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aucune tache trouvee !"));

        Projet projet = projetRepo.findById(tacheDTO.getProjectDTO().getId())
                .orElseThrow(() -> new IllegalArgumentException("Projet introuvable !"));

        if (tacheDTO.getId() == null){
            tacheDTO.setId(tacheFound.getId());
        }
        tacheFound.setTitre(tacheDTO.getTitre());
        tacheFound.setDescription(tacheDTO.getDescription());
        tacheFound.setEtat(tacheDTO.getEtat());
        tacheFound.setProjet(projet);

        Tache tacheUpdated = tacheRepo.save(tacheFound);

        return tacheMapper.toDto(tacheUpdated);
    }


    @Override
    public void deleteTache(Long id) {
        Optional<Tache> tacheSearch = tacheRepo.findById(id);
        if (tacheSearch.isEmpty()){
            throw new IllegalArgumentException("Tache introuvable !");
        }
        Tache tacheFound = tacheSearch.get();
        tacheFound.setEtat(ETAT.SUPPRIME);

        tacheRepo.save(tacheFound);
    }
}
