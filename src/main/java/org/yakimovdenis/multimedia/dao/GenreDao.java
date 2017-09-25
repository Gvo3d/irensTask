package org.yakimovdenis.multimedia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yakimovdenis.multimedia.models.Genre;

@Repository
public interface GenreDao extends JpaRepository<Genre, Integer> {
}
