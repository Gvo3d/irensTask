package org.yakimovdenis.multimedia.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "objs_to_genres", joinColumns = @JoinColumn(name = "gnr_id"), inverseJoinColumns = @JoinColumn(name = "obj_id"))
    private Set<DBEntity> objects;

}
