package cs544;

import jakarta.persistence.EntityManager;

public class StudentService {
	private StudentDAO studentdao;

	public StudentService() {
		studentdao = new StudentDAO();
	}

	public Student getStudent(long studentid) {
		EntityManager em = EntityManagerHelper.getCurrent();
		em.getTransaction().begin();

		Student result = studentdao.loadStudent(studentid);

		em.getTransaction().commit();
		em.close();
//		EntityManagerHelper.closeEntityManagerFactory();

		return result;
	}
}
