package org.yakimovdenis.multimedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yakimovdenis.multimedia.dao.GenreDao;
import org.yakimovdenis.multimedia.models.Genre;

import java.util.List;

@Service
public class GenresServiceImpl implements GenresService {

    @Autowired
    private GenreDao genreDao;

    public Genre getOne(Integer id){
        return genreDao.getOne(id);
    }

    public List<Genre> getAll(){
        return genreDao.findAll();
    }

    public void persist(Genre genre){
        genreDao.save(genre);
    }

    public void delete(Integer id){
        genreDao.delete(id);
    }
}
