package edu.javavt17Second.dao.hibernate;

import edu.javavt17Second.dao.DirectorDAO;
import edu.javavt17Second.model.Director;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class DirectorDAOHibernateImpl implements DirectorDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void saveOrUpdate(Director item) {
        if (item.getIdDirector() > 0) {
            //update
            getCurrentSession().merge(item);
        } else {
            //insert
            getCurrentSession().save(item);
        }

    }

    public void delete(int itemId) {
        Director director = get(itemId);
        if (director != null)
            getCurrentSession().delete(director);
    }

    public Director get(int itemId) {
        Director director = (Director) getCurrentSession().get(Director.class, itemId);

        return director;
    }

    public List<Director> list() {
        Criteria criteria = getCurrentSession().createCriteria(Director.class);

        return criteria.list();
    }
}