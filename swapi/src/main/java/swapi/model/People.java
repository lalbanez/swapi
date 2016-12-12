package swapi.model;

import java.io.Serializable;

public class People implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", gender=" + gender + "]";
	}

}
