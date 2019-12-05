package edu.javavt17Second.service;

import edu.javavt17Second.model.Director;
import java.util.List;

public interface DirectorService {

    void saveOrUpdate(Director item);

    void delete(int itemId);

    Director get(int itemId);

    List<Director> list();
}