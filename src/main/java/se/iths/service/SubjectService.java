package se.iths.service;

import se.iths.entity.Subject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;

    public Subject findSubjectById(Long id) {
        return entityManager.find(Subject.class, id);
    }

    public Subject createSubject(Subject subject) {
        try {
            entityManager.persist(subject);
            return subject;
        } catch (Exception ex) {
            return null;
        }
    }

    public List<Subject> getAllSubjects() {
        return entityManager.createQuery("SELECT i from Subject i", Subject.class).getResultList();
    }

    public List<Subject> findSubjectInfoByName(String subject) {
        return entityManager.createQuery("SELECT i from Subject i WHERE i.subject LIKE :teacher", Subject.class).setParameter("teacher", subject).getResultList();
    }

    public List<Subject> getAllSubjectsSortedByCategoryCriteria() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Subject> criteriaQuery = criteriaBuilder.createQuery(Subject.class);
        Root<Subject> subject = criteriaQuery.from(Subject.class);
        criteriaQuery.orderBy(criteriaBuilder.asc(subject.get("subject")));
        TypedQuery<Subject> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

}
