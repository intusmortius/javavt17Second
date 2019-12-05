package edu.javavt17Second.dao;

import edu.javavt17Second.model.Film;

import java.util.List;

public interface FilmDAO {

    void saveOrUpdate(Film item);

    void delete(int itemId);

    Film get(int itemId);

    List<Film> list();

}