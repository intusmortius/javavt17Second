package edu.javavt17Second.dao;

import edu.javavt17Second.model.Director;
import java.util.List;

public interface DirectorDAO{

    void saveOrUpdate(Director item);

    void delete(int itemId);

    Director get(int itemId);

    List<Director> list();

}