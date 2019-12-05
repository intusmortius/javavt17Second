package edu.javavt17Second.dao.jdbc;

import edu.javavt17Second.dao.DirectorDAO;
import edu.javavt17Second.model.Director;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


public class DirectorDAOJdbcImpl implements DirectorDAO {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public DirectorDAOJdbcImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveOrUpdate(Director item) {
        if (item.getIdDirector() > 0) {
            // update
            System.out.println("Director update");
            String sql = "UPDATE directors SET last_name=?, first_name=?, year=?  WHERE id=?";
            jdbcTemplate.update(sql, item.getLastName(), item.getFirstName(), item.getYear(), item.getIdDirector());
        } else {
            // insert
            System.out.println("Director insert");
            String sql = "INSERT INTO directors (last_name, first_name, year)"
                    + " VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, item.getLastName(), item.getFirstName(), item.getYear());
        }
    }

    public void delete(int itemId) {
        String sql = "DELETE FROM directors WHERE id=?";
        jdbcTemplate.update(sql, itemId);
    }

    public Director get(int itemId) {
        String sql = "SELECT * FROM directors WHERE id=" + itemId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Director>() {

            public Director extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    return getDirectorFromDB(rs);
                }
                return null;
            }
        });
    }

    public List<Director> list() {
        String sql = "SELECT * FROM directors";
        List<Director> listDirector = jdbcTemplate.query(sql, new RowMapper<Director>() {

            public Director mapRow(ResultSet rs, int i) throws SQLException {

                return getDirectorFromDB(rs);
            }
        });
        return listDirector;
    }

    private Director getDirectorFromDB(ResultSet rs) throws SQLException{
        Director director = new Director();
        director.setIdDirector(rs.getInt("id"));
        director.setLastName(rs.getString("last_name"));
        director.setFirstName(rs.getString("first_name"));
        director.setYear(rs.getShort("year"));
        return director;
    }
}