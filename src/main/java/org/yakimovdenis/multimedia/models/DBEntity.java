package org.yakimovdenis.multimedia.models;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "objects")
public class DBEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "type")
    private MediaType type;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "objs_to_genres", joinColumns = @JoinColumn(name = "obj_id"), inverseJoinColumns = @JoinColumn(name = "gnr_id"))
    private Set<Genre> genre = new HashSet<>();
    @Column(name = "created")
    private Date creationDate;
    @Column(name = "status")
    private String status;
}
