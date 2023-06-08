package cs544;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@NoArgsConstructor
@Data
public class Student {
	@Id
	private long studentid;
	private String firstname;
	private String lastname;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Collection<Course> courselist = new ArrayList<>();


	public Student(long studentid, String firstname, String lastname) {
		this.studentid = studentid;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public void addCourse(Course course) {
		this.courselist.add(course);
	}

}
