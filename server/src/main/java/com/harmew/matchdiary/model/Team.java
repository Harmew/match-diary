package com.harmew.matchdiary.model;

import com.harmew.matchdiary.dto.team.TeamRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity(name = "team")
@Table(name = "tb_team")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "state")
    private String state;

    @Column(name = "photo_url")
    private String photoUrl;

    public Team(TeamRequestDTO data) {
        this.name = data.name();
        this.state = data.state();
        this.photoUrl = data.photoUrl();
    }

}
