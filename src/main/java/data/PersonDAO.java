package data;

import model.Course;
import model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class PersonDAO {

    private final EntityManagerFactory emf;

    public PersonDAO() {
        emf = EMFactory.getEMF();
    }

    public Person getPersonById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Person.class, id);
    }

    public List<Person> getPersonsByCourse(Course course) {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("FROM Person WHERE course_id LIKE '" + course.getId() + "'", Person.class).getResultList();
    }

    public List<Person> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("FROM Person", Person.class).getResultList();
    }

    public void addPerson(Person person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
    }

    public void updatePerson(Person person)  {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    public void deletePerson(Person person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(person);
        em.getTransaction().commit();
    }
}