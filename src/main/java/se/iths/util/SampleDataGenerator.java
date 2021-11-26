package se.iths.util;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Startup
public class SampleDataGenerator {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData() {

        Student student1 = new Student("Hans", "Sandblom", "email@mail.se", "088765445");
        Student student2 = new Student("Gunde", "Snor", "snor@gmail.se", "0643646763");
        Student student3 = new Student("Sven", "Gurka", "gurka@hotmail.se", "0765236452");
        Student student4 = new Student("Sven", "Melander", "sven@tjo.com", "05434676");

        Teacher teacher1 = new Teacher("Magister glad");
        Teacher teacher2 = new Teacher("Pontus");
        Teacher teacher3 = new Teacher("Fröken snäll");

        Subject subject1 = new Subject("Matte");
        Subject subject2 = new Subject("Gympa");
        Subject subject3 = new Subject("Fysik");
        Subject subject4 = new Subject("Kemi");
        Subject subject5 = new Subject("Data");

        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(subject1);
        subjectList.add(subject3);
        subjectList.add(subject5);

        student1.setSubjects(subjectList);
        student3.setSubjects(subjectList);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student2);
        studentList.add(student4);

        subject1.setStudents(studentList);

        teacher1.addSubject(subject1);
        teacher1.addSubject(subject2);
        teacher2.addSubject(subject3);
        teacher2.addSubject(subject4);
        teacher3.addSubject(subject5);

        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);
        entityManager.persist(student4);

        entityManager.persist(teacher1);
        entityManager.persist(teacher2);
        entityManager.persist(teacher3);

        entityManager.persist(subject1);
        entityManager.persist(subject2);
        entityManager.persist(subject3);
        entityManager.persist(subject4);
        entityManager.persist(subject5);

    }

}
