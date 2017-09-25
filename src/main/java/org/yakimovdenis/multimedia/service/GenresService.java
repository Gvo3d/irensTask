package org.yakimovdenis.multimedia.service;

import org.yakimovdenis.multimedia.models.Genre;

import java.util.List;

public interface GenresService {
    Genre getOne(Integer id);
    List<Genre> getAll();
    void persist(Genre genre);
    void delete(Integer id);
}
