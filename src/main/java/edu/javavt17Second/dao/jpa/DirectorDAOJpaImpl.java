package edu.javavt17Second.dao.jpa;

import edu.javavt17Second.dao.DirectorDAO;
import edu.javavt17Second.model.Director;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DirectorDAOJpaImpl implements DirectorDAO {
    @PersistenceContext
    private EntityManager em;

    public void saveOrUpdate(Director item) {
        if (item.getIdDirector() > 0) {
            //update
            em.merge(item);
        } else {
            //insert
            em.persist(item);
        }
    }

    public void delete(int itemId) {
        em.remove(get(itemId));

    }

    public Director get(int itemId) {
        return em.find(Director.class, itemId);
    }

    public List<Director> list() {
        List<Director> directors = em.createNamedQuery("Director.findAll",Director.class).getResultList();
        return directors;
    }
}