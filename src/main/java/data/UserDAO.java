package data;

import model.Person;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class UserDAO {

    private final EntityManagerFactory emf;

    public UserDAO() {
        emf = EMFactory.getEMF();
    }

    public User getUserByLogin(String login) {
        EntityManager em = emf.createEntityManager();
        return em.find(User.class, login);
    }

    public List<User> getUsersByPerson(Person person) {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("FROM User WHERE person_id LIKE '" + person.getId() + "'", User.class).getResultList();
    }

    public List<User> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("FROM User", User.class).getResultList();
    }

    public void addUser(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public void updateUser(User user)  {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public void deleteUser(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }
}