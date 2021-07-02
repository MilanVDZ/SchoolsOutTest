import model.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SchoolsOutApp {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Milan");
        EntityManager em = emf.createEntityManager();

        Course course = new Course();
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
    }
}
