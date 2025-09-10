package com.yield.todo_list.controller;


import com.yield.todo_list.dto.TacheDTO;
import com.yield.todo_list.entity.Tache;
import com.yield.todo_list.service.TacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class TacheController {

    private final TacheService tacheService;


    @PostMapping("/tache/added")
    public ResponseEntity<TacheDTO> addTache(@RequestBody TacheDTO tacheDTO){

        TacheDTO tacheAdd = tacheService.addTache(tacheDTO);

        return new ResponseEntity<>(tacheAdd, HttpStatus.OK);
    }


    @GetMapping("/taches/list")
    public ResponseEntity<List<TacheDTO>> getAllTaches(){
        List<TacheDTO> tacheDTOList = tacheService.getTaches();

        return new ResponseEntity<>(tacheDTOList, HttpStatus.OK);
    }

    @GetMapping("/tache/{id}/detail")
    public ResponseEntity<TacheDTO> tacheDetail(@PathVariable Long id){

        TacheDTO tacheDTODetail = tacheService.getTache(id);

        return new ResponseEntity<>(tacheDTODetail, HttpStatus.OK);
    }

    @PutMapping("/tache/{id}/updated")
    public ResponseEntity<TacheDTO> updateTache(@PathVariable Long id, @RequestBody TacheDTO tacheDTO){

        TacheDTO tacheUpd = tacheService.updateTache(id, tacheDTO);

        return new ResponseEntity<>(tacheDTO, HttpStatus.OK);
    }

    @DeleteMapping("/tache/{id}/delete")
    public ResponseEntity<String> deleteTache(@PathVariable Long id){

        tacheService.deleteTache(id);

        return new ResponseEntity<>("Tache supprime avec succes !", HttpStatus.OK);
    }
}
