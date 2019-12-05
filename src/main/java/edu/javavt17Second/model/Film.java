package edu.javavt17Second.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="films")
@NamedQuery(name="Film.findAll", query="select m from Film m")
public class Film implements Serializable {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(insertable = false, updatable = false)
    private int director;

    @ManyToOne
    @JoinColumn(name = "director")
    private Director director_;

    @NotEmpty @Column
    private String name;
    @Column private short year;

    public Film() {}

    public int getIdFilm() {
        return id;
    }

    public int getIdDirector() {
        return director;
    }

    public Director getDirector() {
        return director_;
    }

    public String getName() {
        return name;
    }

    public short getYear() {
        return year;
    }

    public void setIdFilm(int idFilm) {
        this.id = idFilm;
    }

    public void setIdDirector(int idDirector) {
        this.director = idDirector;
    }

    public void setDirector(Director director_) {
        this.director_ = director_;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(short year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Film{" +
                "idFilm=" + id +
                ", director=" + director_.getLastName() + director_.getFirstName() +
                ", idDirector=" + director +
                ", Name='" + name + '\'' +
                ", Year=" + year +
                '}';
    }
}