package com.tomorrow.tomorrow.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
@Entity
public class Team  implements Serializable {
    private static final long serializable = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long team_id;

    @Column(nullable = false)
    private Set<Long> students_id = new HashSet<>();

    @Column(nullable = false)
    private Long course_id;

    @Column(nullable = false)
    private Long teacher_id;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double value;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(team_id, team.team_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(team_id);
    }
}