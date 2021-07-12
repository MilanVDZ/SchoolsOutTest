package model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Person person;
    @ManyToOne
    private Exam exam;
    private BigDecimal gradeValue;
    private String comment;
    private String internalComment;
    private boolean absent;
    private boolean postponed;
    private LocalDate date;

    public Grade() {

    }

    public Grade(Person person, Exam exam, BigDecimal gradeValue, String comment, String internalComment, LocalDate date) {
        this.person = person;
        this.exam = exam;
        this.gradeValue = gradeValue;
        this.comment = comment;
        this.internalComment = internalComment;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public Exam getExam() {
        return exam;
    }

    public BigDecimal getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(BigDecimal gradeValue) {
        this.gradeValue = gradeValue;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getInternalComment() {
        return internalComment;
    }

    public void setInternalComment(String internalComment) {
        this.internalComment = internalComment;
    }

    public boolean isAbsent() {
        return absent;
    }

    public void setAbsent(boolean absent) {
        this.absent = absent;
    }

    public boolean isPostponed() {
        return postponed;
    }

    public void setPostponed(boolean postponed) {
        this.postponed = postponed;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", exam=" + exam +
                ", gradeValue=" + gradeValue +
                ", comment='" + comment + '\'' +
                '}';
    }
}