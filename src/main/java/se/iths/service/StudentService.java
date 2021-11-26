package se.iths.service;


import se.iths.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public Student createStudent(Student student) {
        try {
            entityManager.persist(student);
            return student;
        } catch (Exception ex) {
            return null;
        }
    }

    public Student deleteStudent(Long id) {
        Student foundStudent = entityManager.find(Student.class, id);
        if (foundStudent == null) {
            return null;
        }
        entityManager.remove(foundStudent);
        return foundStudent;
    }

    public List<Student> getAllStudents() {
        return entityManager.createQuery("SELECT i from Student i", Student.class).getResultList();
    }

    public Student findStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public List<Student> findStudentByLastName(String lastName) {
        return entityManager.createQuery("SELECT i from Student i WHERE i.lastName LIKE :lastName", Student.class).setParameter("lastName", lastName).getResultList();
    }

    public Student updateFirstName(Long id, String name) {
        Student foundStudent = entityManager.find(Student.class, id);
        if (foundStudent != null) {
            foundStudent.setFirstName(name);
            return entityManager.merge(foundStudent);
        }
        return null;
    }

    public Student updateLastName(Long id, String name) {
        Student foundStudent = entityManager.find(Student.class, id);
        if (foundStudent != null) {
            foundStudent.setLastName(name);
            return entityManager.merge(foundStudent);
        }
        return null;
    }

    public Student updateEmail(Long id, String name) {
        Student foundStudent = entityManager.find(Student.class, id);
        if (foundStudent != null) {
            if (isValidEmail(name) == false) {
                return null;
            }
            foundStudent.setEmail(name);
            return entityManager.merge(foundStudent);
        }
        return null;
    }

    public static boolean isValidEmail(String email)
    {
        if (email != null)
        {
            Pattern p = Pattern.compile("^[A-Za-z].*?@gmail\\.com$");
            Matcher m = p.matcher(email);
            return m.find();
        }
        return false;
    }

    public Student updatePhoneNumber(Long id, String name) {
        Student foundStudent = entityManager.find(Student.class, id);
        if (foundStudent != null) {
            foundStudent.setPhoneNumber(name);
            return entityManager.merge(foundStudent);
        }
        return null;
    }

}
