package se.iths.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@NamedQuery(name = "subjectEntity.findAll", query = "SELECT i FROM Subject i")
@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String subject;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "subjects_students",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    public List<Student> students = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject(String subject) {
        this.subject = subject;
    }

    public Subject() {}

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() { return subject; }

    public void setSubject(String id) {
        this.subject = subject;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
