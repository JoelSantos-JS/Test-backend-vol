package com.joel.br.Test.Vol.model;

import com.joel.br.Test.Vol.model.enums.GroupType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String name;
    private String phoneNumber;
    private String codinome;

    @Enumerated(EnumType.STRING)
    private GroupType groupType;

}
