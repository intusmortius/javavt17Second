package edu.javavt17Second.service;

import edu.javavt17Second.dao.FilmDAO;
import edu.javavt17Second.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("filmJpaService")
@Transactional(readOnly=false, value = "jpaTransactionManager")
public class FilmJpaServiceImpl implements FilmService {
    @Autowired
    @Qualifier("getFilmJpaDAO")
    private FilmDAO filmDAO;

    public void saveOrUpdate(Film item) {
        filmDAO.saveOrUpdate(item);
    }

    public void delete(int itemId) {
        filmDAO.delete(itemId);
    }

    public Film get(int itemId) {
        return filmDAO.get(itemId);
    }

    public List<Film> list() {
        return filmDAO.list();
    }
}
