package com.project.todo.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tarefas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(length = 100, nullable = false)
    private String nome;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 100, nullable = false)
    private Status status = Status.PENDENTE;

    @NotNull
    @Column(nullable = false)
    private LocalDate data;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;
}
