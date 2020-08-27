package com.example.rnwauniversity;

import javax.persistence.*;

@Entity
@Table(name="students", schema = "public")
public class Student {

    @Id
    @Column(name = "StudentId", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Name", nullable = false)
    private String ime;

    @Column(name = "Faculties_FacultyId")
    @JoinColumn(name="FacultyId")
    private int fakultetId;

    public Student() {
    }

    
    public Student(int id, String ime, int fId) {
        this.id = id;
        this.ime = ime;
        this.fakultetId = fId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getFakultetId() {
        return fakultetId;
    }

    public void setFakultetId(int fakultetId) {
        this.fakultetId = fakultetId;
    }
    
    
}
