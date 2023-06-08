package cs544;

import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StudentDAO {
    public void saveStudent(Student student) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.persist(student);
    }
    public void updateStudent(Student student) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.merge(student);
    }
    public Student loadStudent(long studentid) {
        EntityManager em = EntityManagerHelper.getCurrent();

//        EntityGraph<Student> entityGraph = em.createEntityGraph(Student.class);
//        entityGraph.addAttributeNodes("studentid");
//        entityGraph.addAttributeNodes("firstname");
//
//        Map<String, Object> properties = new HashMap<>();
//        properties.put("jakarta.persistence.fetchgraph", entityGraph);
//        Student student = em.find(Student.class, studentid, properties);
//
//        return student;
        return em.find(Student.class, studentid);
    }

    public Collection<Student> getAccounts() {
        EntityManager em = EntityManagerHelper.getCurrent();

        TypedQuery<Student> query = em.createQuery("FROM Student ", Student.class);
//        TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a JOIN a.entryList", Account.class);
        return query.getResultList();
    }
}
