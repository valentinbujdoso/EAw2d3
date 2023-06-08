package cs544;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Course {
	@Id
	private long coursenumber;
	private String name;
	private String grade;

	public Course(long coursenumber, String name, String grade) {
		this.name = name;
		this.grade = grade;
	}


}
