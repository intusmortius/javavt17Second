package edu.javavt17Second.dao.jdbc;

import edu.javavt17Second.dao.DirectorDAO;
import edu.javavt17Second.dao.FilmDAO;
import edu.javavt17Second.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FilmDAOJdbcImpl implements FilmDAO {
    @Autowired
    @Qualifier("getDirectorJdbcDAO")
    private DirectorDAO directorDAO;

    private JdbcTemplate jdbcTemplate;

    public FilmDAOJdbcImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveOrUpdate(Film item) {
        if (item.getIdFilm() > 0) {
            // update
            String sql = "UPDATE films SET director=?, name=?, year=?, WHERE id=?";
            jdbcTemplate.update(sql, item.getIdDirector(), item.getName(),item.getYear(),
                     item.getIdFilm());
        } else {
            // insert
            String sql = "INSERT INTO films (director, name, year)"
                    + " VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, item.getIdDirector(), item.getName(),
                    item.getYear());
        }
    }

    public void delete(int itemId) {
        String sql = "DELETE FROM films WHERE id=?";
        jdbcTemplate.update(sql, itemId);
    }

    public Film get(int itemId) {
        String sql = "SELECT * FROM films WHERE id=" + itemId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Film>() {

            public Film extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    return getFilmFromDB(rs);
                }
                return null;
            }
        });
    }

    public List<Film> list() {
        String sql = "SELECT * FROM films";
        List<Film> listFilm = jdbcTemplate.query(sql, new RowMapper<Film>() {

            public Film mapRow(ResultSet rs, int i) throws SQLException {

                return getFilmFromDB(rs);
            }
        });
        return listFilm;
    }

    private Film getFilmFromDB(ResultSet rs) throws SQLException{
        Film film = new Film();
        film.setIdFilm(rs.getInt("id"));
        film.setIdDirector(rs.getInt("id"));
        film.setDirector(directorDAO.get(rs.getInt("id")));
        film.setName(rs.getString("Name"));
        film.setYear(rs.getShort("year"));
        return film;
    }
}