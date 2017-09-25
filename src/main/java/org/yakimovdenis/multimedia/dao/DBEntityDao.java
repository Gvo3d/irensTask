package org.yakimovdenis.multimedia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.yakimovdenis.multimedia.models.DBEntity;
import org.yakimovdenis.multimedia.models.MediaType;

import java.util.List;

@Repository
public interface DBEntityDao extends JpaRepository<DBEntity, Integer> {
    public List<DBEntity> getAllByTypeEquals(MediaType type);
    @Query("select o from DBEntity o where o.name = ?#{[0]}")
    public DBEntity getEntityByName(String name);
}
