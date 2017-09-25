package org.yakimovdenis.multimedia.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yakimovdenis.multimedia.models.DBEntity;

import java.util.List;

@Repository
public interface DBEntityDao extends JpaRepository<DBEntity, Integer> {
    @Query("select o from objects o where o.type = ?#{[0]}")
    public List<DBEntity> getEntitiesByType(Integer type);
    @Query("select o from objects o where o.name = ?#{[0]}")
    public DBEntity getEntityByName(String name);
}
