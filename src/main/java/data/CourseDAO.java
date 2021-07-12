package data;

import model.Course;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


public class CourseDAO {

    private final EntityManagerFactory emf;

    public CourseDAO() {
        emf = EMFactory.getEMF();
    }

    public Course getCourseById(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Course.class, id);
    }

    public Course getCourseByName(String courseName) {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("FROM Course WHERE name LIKE '" + courseName + "'", Course.class).getSingleResult();
    }

    public List<Course> getAllCourses() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("FROM Course", Course.class).getResultList();
    }

    public void addCourse(Course course) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
    }

    public void updateCourse(Course course)  {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(course);
        em.getTransaction().commit();
    }

    public void deleteCourse(Course course) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(course);
        em.getTransaction().commit();
    }
}