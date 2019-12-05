package edu.javavt17Second.dao.jpa;

import edu.javavt17Second.dao.FilmDAO;
import edu.javavt17Second.model.Film;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FilmDAOJpaImpl implements FilmDAO {
    @PersistenceContext
    private EntityManager em;

    public void saveOrUpdate(Film item) {
        if (item.getIdDirector() > 0) {
            // update
            em.merge(item);
        } else {
            // insert
            em.persist(item);
        }
    }

    public void delete(int itemId) {
        em.remove(get(itemId));
    }

    public Film get(int itemId) {
        return em.find(Film.class, itemId);
    }

    public List<Film> list() {
        List<Film> carModels = em.createNamedQuery("Film.findAll",Film.class).getResultList();
        return carModels;
    }
}
