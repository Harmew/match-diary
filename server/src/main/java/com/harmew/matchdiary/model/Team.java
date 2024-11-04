package com.harmew.matchdiary.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "team")
@Table(name = "tb_team")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "state")
    private String state;

    @Column(name = "photo_url")
    private String photoUrl;

}
