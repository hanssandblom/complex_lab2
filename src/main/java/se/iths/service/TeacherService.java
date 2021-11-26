package se.iths.service;

import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TeacherService {

    @PersistenceContext
    EntityManager entityManager;

    public Teacher findTeacherById(Long id) {
        return entityManager.find(Teacher.class, id);
    }

    public Teacher createTeacher(Teacher teacher) {
        try {
            entityManager.persist(teacher);
            return teacher;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Teacher> getAllTeachers() {
        return entityManager.createQuery("SELECT i from Teacher i", Teacher.class).getResultList();
    }

}
