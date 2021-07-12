package data;

import model.Course;
import model.Module;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ModuleDAO {

    private final EntityManagerFactory emf;

    public ModuleDAO() {
        emf = EMFactory.getEMF();
    }

    public Module getModuleById(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Module.class, id);
    }

    public Module getModuleByName(String moduleName) {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("FROM Module WHERE name LIKE '" + moduleName + "'", Module.class).getSingleResult();
    }

    public List<Module> getModulesByCourse(Course course) {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("FROM Module WHERE course_id LIKE '" + course.getId() + "'", Module.class).getResultList();
    }

    public List<Module> getAllModules() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("FROM Module", Module.class).getResultList();
    }

    public void addModule(Module module) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(module);
        em.getTransaction().commit();
    }

    public void updateModule(Module module)  {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(module);
        em.getTransaction().commit();
    }

    public void deleteModule(Module module) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(module);
        em.getTransaction().commit();
    }
}