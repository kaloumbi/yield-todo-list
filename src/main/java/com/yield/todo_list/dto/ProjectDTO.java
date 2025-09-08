package com.yield.todo_list.dto;

import com.yield.todo_list.enums.ETAT;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectDTO {

    private Long id;

    private String titre;

    private String description;

    private ETAT etat;
}
