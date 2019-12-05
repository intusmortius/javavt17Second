package edu.javavt17Second.service;

import edu.javavt17Second.model.Film;
import java.util.List;

public interface FilmService {
    void saveOrUpdate(Film item);

    void delete(int itemId);

    Film get(int itemId);

    List<Film> list();
}