package com.yield.todo_list.service.impl;

import com.yield.todo_list.dto.TacheDTO;
import com.yield.todo_list.entity.Tache;
import com.yield.todo_list.enums.ETAT;
import com.yield.todo_list.mapper.TacheMapper;
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

    private final TacheMapper tacheMapper;

    @Override
    public TacheDTO addTache(TacheDTO tacheDTO) {
        Tache tache = tacheMapper.toEntity(tacheDTO);
        tache.setEtat(ETAT.ACTIF);

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
        Optional<Tache> tacheSearch = tacheRepo.findById(id);
        if (tacheSearch.isEmpty()){
            throw new IllegalArgumentException("Tache introuvable !");
        }
        Tache tacheFound = tacheSearch.get();
        if (tacheDTO.getId() == null){
            tacheDTO.setId(tacheFound.getId());
        }
        tacheFound = tacheMapper.toEntity(tacheDTO);
        return tacheMapper.toDto(tacheRepo.save(tacheFound));
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
