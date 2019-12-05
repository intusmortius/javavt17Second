package edu.javavt17Second.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "directors")
@NamedQuery(name = "Director.findAll", query = "select c from Director c")
public class Director implements Serializable {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @NotEmpty @Column(unique=true, nullable=false)
    private String last_name;

    @Column private String first_name;

    @Column private short year;

    public Director() {}

    public void setIdDirector(int idDirector) {
        this.id = idDirector;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public void setYear(short Year) {
        this.year = Year;
    }

    public int getIdDirector() {
        return id;
    }

    public String getLastName() {
        return last_name;
    }

    public String getFirstName() {
        return first_name;
    }

    public short getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Director{" +
                "idDirector=" + id +
                ", lastName='" + last_name +  ", firstName='" + first_name + '\'' +
                ", Year=" + year  + '\'' +
                '}';
    }
}