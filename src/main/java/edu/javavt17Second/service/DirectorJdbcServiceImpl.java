package edu.javavt17Second.service;

import edu.javavt17Second.dao.DirectorDAO;
import edu.javavt17Second.model.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("directorJdbcService")
public class DirectorJdbcServiceImpl implements DirectorService {
    @Autowired
    @Qualifier("getDirectorJdbcDAO")
    private DirectorDAO directorDAO;

    public void saveOrUpdate(Director item) {
        directorDAO.saveOrUpdate(item);
    }

    public void delete(int itemId) {
        directorDAO.delete(itemId);
    }

    public Director get(int itemId) {
        return directorDAO.get(itemId);
    }

    public List<Director> list() {
        return directorDAO.list();
    }
}