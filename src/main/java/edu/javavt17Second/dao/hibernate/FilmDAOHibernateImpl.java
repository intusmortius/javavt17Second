package edu.javavt17Second.dao.hibernate;

import edu.javavt17Second.dao.FilmDAO;
import edu.javavt17Second.model.Film;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class FilmDAOHibernateImpl implements FilmDAO{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void saveOrUpdate(Film item) {
        if (item.getIdFilm() > 0) {
            getCurrentSession().merge(item);
        } else {
            getCurrentSession().save(item);
        }

    }

    public void delete(int itemId) {
        Film film = get(itemId);
        if (film != null)
            getCurrentSession().delete(film);
    }

    public Film get(int itemId) {
        Film film = (Film) getCurrentSession().get(Film.class, itemId);

        return film;
    }

    public List<Film> list() {
        Criteria criteria = getCurrentSession().createCriteria(Film.class);

        return criteria.list();
    }
}