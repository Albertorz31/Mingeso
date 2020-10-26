package mingeso.cibackend.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.List;


@Entity
@Table(name = "student")
public class Student implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="id_career")
    private Career career;

    @Column(name = "name")
    private String name;
    @Column(name = "rut")
    private String rut;
    @Column(name = "birthdate")
    private Date birthdate;

    public Student(){}

    public Student(String name, String rut, Date birthdate, Career career){
        this.name = name;
        this.rut = rut;
        this.birthdate = birthdate;
        this.career = career;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }
}
