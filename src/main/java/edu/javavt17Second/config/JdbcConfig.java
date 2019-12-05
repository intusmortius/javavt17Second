package edu.javavt17Second.config;

import edu.javavt17Second.dao.DirectorDAO;
import edu.javavt17Second.dao.FilmDAO;
import edu.javavt17Second.dao.jdbc.DirectorDAOJdbcImpl;
import edu.javavt17Second.dao.jdbc.FilmDAOJdbcImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {
    @Autowired
    private DataSource dataSource;

    @Bean
    public DirectorDAO getDirectorJdbcDAO() {
        return new DirectorDAOJdbcImpl(dataSource);
    }
    @Bean
    public FilmDAO getFilmJdbcDAO() {
        return new FilmDAOJdbcImpl(dataSource);
    }
}