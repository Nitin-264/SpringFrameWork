package in.pwskills.nitin.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="stdTable")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="sid")
	private Integer stdId;
	
	@Column(name ="sname")
	@NotEmpty(message = "sname can't be empty")
	private String stdName;
	
	@Column(name ="sgen")
	@NotEmpty(message = "sgen can't be empty")
	private String stdGen;
	
	@Column(name ="scourse")
	@NotEmpty(message = "scourse can't be empty")
	private String stdCourse;
	
	@Column(name ="saddr")
	@NotEmpty(message = "saddr can't be empty")
	private String stdAddr;
	
}
