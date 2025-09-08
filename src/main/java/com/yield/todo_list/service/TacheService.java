package com.yield.todo_list.service;

import com.yield.todo_list.dto.TacheDTO;
import com.yield.todo_list.entity.Tache;

import java.util.List;

public interface TacheService {

    TacheDTO addTache(TacheDTO tacheDTO);

    List<TacheDTO> getTaches();

    TacheDTO getTache(Long id);

    TacheDTO updateTache(Long id, TacheDTO tacheDTO);

    void deleteTache(Long id);
}
