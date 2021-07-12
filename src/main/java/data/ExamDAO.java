package data;

import model.Exam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class ExamDAO {

    private final EntityManagerFactory emf;

    public ExamDAO() {
        emf = EMFactory.getEMF();
    }

    public Exam getExamById(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Exam.class, id);
    }

    public Exam getExamByName(String examName) {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("FROM Course WHERE name LIKE '" + examName + "'", Exam.class).getSingleResult();
    }

    public List<Exam> getAllExams() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select e From Exam e");
        List<Exam> examList = query.getResultList();
        return examList;
    }

    public void addExam(Exam exam) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(exam);
        em.getTransaction().commit();
    }

    public void updateExam(Exam exam)  {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(exam);
        em.getTransaction().commit();
    }

    public void deleteExam(Exam exam) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(exam);
        em.getTransaction().commit();
    }
}