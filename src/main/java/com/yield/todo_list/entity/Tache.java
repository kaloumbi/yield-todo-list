package com.yield.todo_list.entity;

import com.yield.todo_list.enums.ETAT;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "description")
    private String description;

    @Column(name = "etat", nullable = false)
    @Enumerated(EnumType.STRING)
    private ETAT etat;

    @ManyToOne
    @JoinColumn(name = "projet_id", referencedColumnName = "id")
    private Projet projet;
}
