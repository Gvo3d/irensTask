package org.yakimovdenis.multimedia.service;

import org.yakimovdenis.multimedia.models.DBEntity;
import org.yakimovdenis.multimedia.models.Genre;
import org.yakimovdenis.multimedia.models.MediaType;

import java.util.List;

public interface DBEntitysService {
    DBEntity getOne(Integer id);
    List<DBEntity> getAll();
    void persist(DBEntity genre);
    void delete(Integer id);
    List<DBEntity> getAllWithType(MediaType type);
    DBEntity getEntityByName(String name);
}
