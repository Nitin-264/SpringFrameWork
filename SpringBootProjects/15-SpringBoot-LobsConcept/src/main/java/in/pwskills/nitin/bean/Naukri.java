package in.pwskills.nitin.bean;

import java.io.File;
import java.io.Serializable;

public class Naukri implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String Address;
	private String Name;

	private File Image;
	private File Resume;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public File getImage() {
		return Image;
	}
	public void setImage(File image) {
		Image = image;
	}
	public File getResume() {
		return Resume;
	}
	public void setResume(File resume) {
		Resume = resume;
	}
	@Override
	public String toString() {
		return "Naukri [id=" + id + ", Address=" + Address + ", Name=" + Name + ", Image=" + Image + ", Resume="
				+ Resume + "]";
	}
	
	
}
