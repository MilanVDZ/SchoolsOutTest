package model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstname;
    private String familyname;
    private Gender gender;
    @ManyToOne
    private Course course;
    @ManyToMany
    private List<Course> courseHistory;

    public Person() {
    }

    public Person(Integer id, String firstname, String familyname, Gender gender, Course course) {
        this.id = id;
        this.firstname = firstname;
        this.familyname = familyname;
        this.gender = gender;
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Course> getCourseHistory() {
        return courseHistory;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", familyname='" + familyname + '\'' +
                ", gender=" + gender +
                ", course=" + course +
                ", courseHistory=" + courseHistory +
                '}';
    }
}

