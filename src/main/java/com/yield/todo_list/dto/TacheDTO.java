package com.yield.todo_list.dto;

import com.yield.todo_list.enums.ETAT;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TacheDTO {

    private Long id;

    private String titre;

    private String description;

    private ETAT etat;

    private ProjectDTO projectDTO;

}
