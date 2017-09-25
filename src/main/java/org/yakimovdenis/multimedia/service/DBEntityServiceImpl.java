package org.yakimovdenis.multimedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yakimovdenis.multimedia.dao.DBEntityDao;
import org.yakimovdenis.multimedia.models.DBEntity;
import org.yakimovdenis.multimedia.models.MediaType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class DBEntityServiceImpl implements DBEntitysService {

    @Autowired
    private DBEntityDao dbEntityDao;

    public DBEntity getOne(Integer id){
        return dbEntityDao.findOne(id);
    }

    public List<DBEntity> getAll(){
        return dbEntityDao.findAll();
    }

    public List<DBEntity> getAllWithType(MediaType type){
        return dbEntityDao.getAllByTypeEquals(type);
    }

    @Override
    public DBEntity getEntityByName(String name) {
        return dbEntityDao.getEntityByName(name);
    }

    public void persist(DBEntity dbEntity){
        dbEntityDao.save(dbEntity);
    }
    
    public void delete(Integer id){
        dbEntityDao.delete(id);
    }
}
